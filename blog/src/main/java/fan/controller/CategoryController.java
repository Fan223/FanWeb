package fan.controller;

import fan.lang.Response;
import fan.pojo.dto.CategoryDTO;
import fan.pojo.query.CategoryQuery;
import fan.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类管理 Controller
 *
 * @author Fan
 * @since 2023/6/9 16:01
 */
@RestController
@RequestMapping("/blog/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/pageCategories")
    public Response pageCategories(CategoryQuery categoryQuery) {
        return categoryService.page(categoryQuery);
    }

    @GetMapping("/listCategories")
    public Response listCategories() {
        return categoryService.list(CategoryQuery.builder().flag("Y").build());
    }

    @PostMapping("/addCategory")
    public Response addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.insert(categoryDTO);
    }

    @PutMapping("/updateCategory")
    public Response updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.update(categoryDTO);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public Response deleteCategory(@PathVariable("id") List<String> ids) {
        return categoryService.delete(ids);
    }
}
