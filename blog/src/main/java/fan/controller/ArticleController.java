package fan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.ArticleDTO;
import fan.pojo.query.ArticleQuery;
import fan.pojo.vo.ArticleVO;
import fan.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * 文章管理 Controller
 *
 * @author Fan
 * @since 2023/6/9 15:13
 */
@RestController
@RequestMapping("/blog/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/pageArticles")
    public Response<Page<ArticleVO>> pageArticles(ArticleQuery articleQuery) {
        return articleService.pageArticles(articleQuery);
    }

    @GetMapping("/getArticle/{id}")
    public Response<ArticleVO> getArticle(@PathVariable("id") String id) {
        return articleService.getArticle(id);
    }

    @PostMapping("/saveArticle")
    public Response<String> saveArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.saveArticle(articleDTO);
    }

    @DeleteMapping("/deleteArticle/{id}")
    public Response<Integer> deleteArticle(@PathVariable("id") List<String> ids) {
        return articleService.deleteArticle(ids);
    }
}
