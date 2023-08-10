package fan.controller;

import fan.lang.Response;
import fan.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 博客管理 Controller
 *
 * @author Fan
 * @since 2023/8/10 8:54
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @GetMapping("/cleanInvalidImage")
    public Response<Integer> cleanInvalidImage() {
        return blogService.cleanInvalidImage();
    }

    @GetMapping("/exportArticle")
    public Response<Map<String, Integer>> exportArticle() {
        return blogService.exportArticle();
    }
}
