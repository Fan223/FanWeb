package fan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.TagDTO;
import fan.pojo.query.TagQuery;
import fan.pojo.vo.TagVO;
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
    public Response<Page<TagVO>> pageTags(TagQuery tagQuery) {
        return tagService.pageTags(tagQuery);
    }

    @PostMapping("/addTag")
    public Response<Integer> addTag(@RequestBody TagDTO tagDTO) {
        return tagService.addTag(tagDTO);
    }

    @PutMapping("/updateTag")
    public Response<Integer> updateTag(@RequestBody TagDTO tagDTO) {
        return tagService.updateTag(tagDTO);
    }

    @DeleteMapping("/deleteTag/{id}")
    public Response<Integer> deleteTag(@PathVariable("id") List<String> ids) {
        return tagService.deleteTag(ids);
    }
}
