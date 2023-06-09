package fan.controller;

import fan.lang.Response;
import fan.pojo.dto.ArticleDTO;
import fan.pojo.query.ArticleQuery;
import fan.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public Response pageArticles(ArticleQuery articleQuery) {
        return articleService.page(articleQuery);
    }

    @GetMapping("/getArticle/{id}")
    public Response getArticle(@PathVariable("id") String id) {
        return articleService.get(id);
    }

    @PostMapping("/saveArticle")
    public Response saveArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.insert(articleDTO);
    }

    @DeleteMapping("/deleteArticle/{id}")
    public Response deleteArticle(@PathVariable("id") List<String> ids) {
        return articleService.delete(ids);
    }
}
