package fan.controller;

import fan.lang.Response;
import fan.pojo.dto.TagDTO;
import fan.pojo.query.TagQuery;
import fan.service.TagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签管理 Controller
 *
 * @author Fan
 * @since 2023/6/21 13:51
 */
@RestController
@RequestMapping("/blog/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/pageTags")
    public Response pageTags(TagQuery tagQuery) {
        return tagService.page(tagQuery);
    }

    @PostMapping("/addTag")
    public Response addTag(@RequestBody TagDTO tagDTO) {
        return tagService.insert(tagDTO);
    }

    @PutMapping("/updateTag")
    public Response updateTag(@RequestBody TagDTO tagDTO) {
        return tagService.update(tagDTO);
    }

    @DeleteMapping("/deleteTag/{id}")
    public Response deleteTag(@PathVariable("id") List<String> ids) {
        return tagService.delete(ids);
    }
}
