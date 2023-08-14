package fan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.CategoryDTO;
import fan.pojo.query.CategoryQuery;
import fan.pojo.vo.CategoryVO;
import fan.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
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
    public Response<Page<CategoryVO>> pageCategories(CategoryQuery categoryQuery) {
        return categoryService.pageCategories(categoryQuery);
    }

    @GetMapping("/listCategories")
    public Response<List<CategoryVO>> listCategories() {
        return categoryService.listCategories(CategoryQuery.builder().flag("Y").build());
    }

    @PostMapping("/addCategory")
    public Response<Integer> addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    @PutMapping("/updateCategory")
    public Response<Integer> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public Response<Integer> deleteCategory(@PathVariable("id") List<String> ids) {
        return categoryService.deleteCategory(ids);
    }
}
