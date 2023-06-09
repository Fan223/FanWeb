package fan.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.pojo.dto.ArticleDTO;
import fan.pojo.dto.CategoryDTO;
import fan.pojo.entity.ArticleDO;
import fan.pojo.entity.CategoryDO;
import fan.pojo.vo.ArticleVO;
import fan.pojo.vo.CategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 博客转换类
 *
 * @author Fan
 * @since 2023/6/9 15:27
 */
@Mapper
public interface BlogMapStruct {

    BlogMapStruct INSTANCE = Mappers.getMapper(BlogMapStruct.class);

    /**
     * 文章实体类转展示类
     *
     * @param articleDO 文章实体类
     * @return {@link ArticleVO}
     * @author Fan
     * @since 2023/6/9 15:27
     */
    @Mapping(target = "createTime", source = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "content", ignore = true)
    ArticleVO transArticle(ArticleDO articleDO);

    /**
     * 文章实体类列表转展示类列表
     *
     * @param articleDos 文章实体类列表
     * @return {@link List<ArticleVO>}
     * @author Fan
     * @since 2023/6/9 15:28
     */
    List<ArticleVO> transArticle(List<ArticleDO> articleDos);

    /**
     * 文章实体类分页转展示类分页
     *
     * @param articlePage 文章实体类分页
     * @return {@link Page<ArticleVO>}
     * @author Fan
     * @since 2023/6/9 15:29
     */
    Page<ArticleVO> transArticle(Page<ArticleDO> articlePage);

    /**
     * 文章更新参数转实体类
     *
     * @param articleDTO 文章更新参数
     * @return {@link ArticleDO}
     * @author Fan
     * @since 2023/6/9 15:29
     */
    ArticleDO transArticle(ArticleDTO articleDTO);

    /**
     * 分类实体类转展示类
     *
     * @param categoryDO 分类实体类
     * @return {@link CategoryVO}
     * @author Fan
     * @since 2023/6/9 16:14
     */
    @Mapping(target = "createTime", source = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    CategoryVO transCategory(CategoryDO categoryDO);

    /**
     * 分类实体类列表转展示类列表
     *
     * @param categoryDos 分类实体类列表
     * @return {@link List<CategoryVO>}
     * @author Fan
     * @since 2023/6/9 16:14
     */
    List<CategoryVO> transCategory(List<CategoryDO> categoryDos);

    /**
     * 分类实体类分页转展示类分页
     *
     * @param categoryPage 分类实体类分页
     * @return {@link Page<CategoryVO>}
     * @author Fan
     * @since 2023/6/9 16:14
     */
    Page<CategoryVO> transCategory(Page<CategoryDO> categoryPage);

    /**
     * 分页更新参数转实体类
     *
     * @param categoryDTO 分类更新参数
     * @return {@link CategoryDO}
     * @author Fan
     * @since 2023/6/9 16:15
     */
    CategoryDO transCategory(CategoryDTO categoryDTO);
}
