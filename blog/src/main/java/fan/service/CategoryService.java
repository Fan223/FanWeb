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

    /**
     * 分页获取分类
     *
     * @param categoryQuery 分类查询参数
     * @return {@link Response<Page<CategoryVO>>}
     * @author Fan
     * @since 2023/7/10 14:10
     */
    Response<Page<CategoryVO>> pageCategories(CategoryQuery categoryQuery);

    /**
     * 获取分类列表
     *
     * @param categoryQuery 分类查询参数
     * @return {@link Response<List<CategoryVO>>}
     * @author Fan
     * @since 2023/7/10 14:11
     */
    Response<List<CategoryVO>> listCategories(CategoryQuery categoryQuery);

    /**
     * 获取分类
     *
     * @param id ID
     * @return {@link Response<CategoryVO>}
     * @author Fan
     * @since 2023/8/10 9:12
     */
    Response<CategoryVO> getCategory(String id);

    /**
     * 添加分类
     *
     * @param categoryDTO 分类更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:12
     */
    Response<Integer> addCategory(CategoryDTO categoryDTO);

    /**
     * 修改分类
     *
     * @param categoryDTO 分类更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:12
     */
    Response<Integer> updateCategory(CategoryDTO categoryDTO);

    /**
     * 删除分类
     *
     * @param ids ID列表
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:12
     */
    Response<Integer> deleteCategory(List<String> ids);
}
