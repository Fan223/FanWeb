package fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.core.util.IdUtil;
import fan.dao.CategoryDAO;
import fan.lang.*;
import fan.pojo.dto.CategoryDTO;
import fan.pojo.entity.CategoryDO;
import fan.pojo.query.CategoryQuery;
import fan.pojo.vo.CategoryVO;
import fan.service.CategoryService;
import fan.utils.BlogMapStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 分类管理实现类
 *
 * @author Fan
 * @since 2023/6/9 16:03
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDAO categoryDAO;

    @Override
    public Response<Page<CategoryVO>> pageCategories(CategoryQuery categoryQuery) {
        try {
            LambdaQueryWrapper<CategoryDO> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.eq(StringUtil.INSTANCE.isNotBlank(categoryQuery.getFlag()), CategoryDO::getFlag, categoryQuery.getFlag())
                    .like(StringUtil.INSTANCE.isNotBlank(categoryQuery.getName()), CategoryDO::getName, categoryQuery.getName())
                    .orderByAsc(CategoryDO::getOrderNum);

            Page<CategoryDO> page = categoryDAO.selectPage(new Page<>(categoryQuery.getCurrentPage(), categoryQuery.getPageSize()), queryWrapper);
            return Response.success(BlogMapStruct.INSTANCE.transCategory(page));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询分类出现异常", null);
        }
    }

    @Override
    public Response<List<CategoryVO>> listCategories(CategoryQuery categoryQuery) {
        try {
            LambdaQueryWrapper<CategoryDO> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.eq(CategoryDO::getFlag, categoryQuery.getFlag())
                    .orderByAsc(CategoryDO::getOrderNum);
            return Response.success(BlogMapStruct.INSTANCE.transCategory(categoryDAO.selectList(queryWrapper)));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询分类出现异常", null);
        }
    }

    @Override
    public Response<Integer> addCategory(CategoryDTO categoryDTO) {
        try {
            CategoryDO categoryDO = BlogMapStruct.INSTANCE.transCategory(categoryDTO);

            categoryDO.setId(String.valueOf(IdUtil.getSnowflakeId()));
            LocalDateTime localDateTime = LocalDateTime.now();
            categoryDO.setCreateTime(Timestamp.valueOf(localDateTime));
            categoryDO.setUpdateTime(Timestamp.valueOf(localDateTime));

            return Response.success(categoryDAO.insert(categoryDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("新增分类出现异常", null);
        }
    }

    @Override
    public Response<Integer> updateCategory(CategoryDTO categoryDTO) {
        try {
            CategoryDO categoryDO = BlogMapStruct.INSTANCE.transCategory(categoryDTO);

            categoryDO.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
            return Response.success(categoryDAO.updateById(categoryDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("更新分类出现异常", null);
        }
    }

    @Override
    public Response<Integer> deleteCategory(List<String> ids) {
        try {
            return Response.success(categoryDAO.deleteBatchIds(ids));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("删除分类出现异常", null);
        }
    }
}
