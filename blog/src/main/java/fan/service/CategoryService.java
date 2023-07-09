package fan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.CategoryDTO;
import fan.pojo.query.CategoryQuery;
import fan.pojo.vo.CategoryVO;

import java.util.List;

/**
 * 分类管理接口
 *
 * @author Fan
 * @since 2023/6/9 16:02
 */
public interface CategoryService {

    Response<Page<CategoryVO>> pageCategories(CategoryQuery categoryQuery);

    Response<List<CategoryVO>> listCategories(CategoryQuery categoryQuery);

    Response<Integer> addCategory(CategoryDTO categoryDTO);

    Response<Integer> updateCategory(CategoryDTO categoryDTO);

    Response<Integer> deleteCategory(List<String> ids);
}
