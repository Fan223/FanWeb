package fan.utils;

import fan.pojo.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * 博客工具类
 *
 * @author Fan
 * @since 2023/8/9 16:22
 */
@Slf4j
public class BlogUtil {

    private static final String ROOT_PATH = "D:/images";

    private BlogUtil() {
    }

    public static Integer cleanInvalidImage(List<ArticleVO> articleVos) {
        Set<String> images = new HashSet<>();

        for (ArticleVO articleVo : articleVos) {
            String content = articleVo.getContent();
            int index = 0;

            while ((index = content.indexOf("img.fan223.cn/", index)) != -1) {
                int startIndex = index + 14;
                int endIndex = content.indexOf(")", startIndex);
                String imgUrl = content.substring(startIndex, endIndex);
                images.add(imgUrl);
                index = endIndex + 1;
            }
        }

        List<String> allImages = getAllImages();
        allImages.removeAll(images);

        for (String allImage : allImages) {
            try {
                Files.delete(Paths.get(ROOT_PATH + "/" + allImage));
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return allImages.size();
    }

    private static List<String> getAllImages() {
        List<String> list = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get(ROOT_PATH))) {
            walk.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    list.add(path.toString().substring(ROOT_PATH.length() + 1).replace("\\", "/"));
                }
            });
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return list;
    }
}
