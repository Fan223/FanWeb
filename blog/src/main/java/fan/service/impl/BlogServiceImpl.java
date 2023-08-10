package fan.service.impl;

import fan.core.util.MapUtil;
import fan.lang.Response;
import fan.pojo.query.ArticleQuery;
import fan.pojo.vo.ArticleVO;
import fan.pojo.vo.CategoryVO;
import fan.service.ArticleService;
import fan.service.BlogService;
import fan.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 博客管理实现类
 *
 * @author Fan
 * @since 2023/8/10 8:57
 */
@Service
@Slf4j
public class BlogServiceImpl implements BlogService {

    private static final String IMAGE_ROOT_PATH = "/usr/fan/images/";

    private static final String BLOG_ROOT_PATH = "/usr/fan/blogs/";

    private static final String WEBSITE = "img.fan223.cn/";

    @Resource
    private ArticleService articleService;

    @Resource
    private CategoryService categoryService;

    @Override
    public Response<Integer> cleanInvalidImage() {
        Response<List<ArticleVO>> articles = articleService.listArticles(ArticleQuery.builder().build());
        Set<String> validImages = new HashSet<>();

        for (ArticleVO articleVo : articles.getData()) {
            String content = articleVo.getContent();
            int index = 0;

            while ((index = content.indexOf(WEBSITE, index)) != -1) {
                int startIndex = index + WEBSITE.length();
                int endIndex = content.indexOf(")", startIndex);
                String imgUrl = content.substring(startIndex, endIndex);
                validImages.add(imgUrl);
                index = endIndex + 1;
            }
        }

        List<String> allImages = getAllImages();
        allImages.removeAll(validImages);

        for (String allImage : allImages) {
            try {
                Files.delete(Paths.get(IMAGE_ROOT_PATH + allImage));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return Response.success("清除失效的图片成功", allImages.size());
    }

    private List<String> getAllImages() {
        List<String> allImages = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get(IMAGE_ROOT_PATH))) {
            walk.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    allImages.add(path.toString().substring(IMAGE_ROOT_PATH.length()).replace("\\", "/"));
                }
            });
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return allImages;
    }

    @Override
    public Response<Map<String, Integer>> exportArticle() {
        Response<List<ArticleVO>> articles = articleService.listArticles(ArticleQuery.builder().build());
        Map<String, List<ArticleVO>> map = articles.getData().stream().collect(Collectors.groupingBy(ArticleVO::getCategoryId));
        int successNum = 0;
        int errorNum = 0;

        for (Map.Entry<String, List<ArticleVO>> entry : map.entrySet()) {
            Response<CategoryVO> category = categoryService.getCategory(entry.getKey());
            String folderPath = BLOG_ROOT_PATH + category.getData().getName();

            boolean mkdirs = new File(folderPath).mkdirs();
            if (!mkdirs) {
                log.error("创建文件夹失败");
                continue;
            }

            for (ArticleVO articleVO : entry.getValue()) {
                String title = articleVO.getTitle().replaceAll("[\\\\/:*?\"<>|]", "");
                try (FileWriter fw = new FileWriter(folderPath + "/" + title + ".md")) {
                    fw.write(articleVO.getContent());
                    fw.flush();
                    successNum++;
                } catch (IOException e) {
                    log.error(e.getMessage());
                    errorNum++;
                }
            }
        }
        return Response.success("导出文章成功", MapUtil.builder("all", articles.getData().size())
                .put("success", successNum).put("error", errorNum).build());
    }
}
