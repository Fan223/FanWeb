package fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.core.util.IdUtil;
import fan.dao.ArticleDAO;
import fan.lang.*;
import fan.pojo.dto.ArticleDTO;
import fan.pojo.entity.ArticleDO;
import fan.pojo.query.ArticleQuery;
import fan.pojo.vo.ArticleVO;
import fan.service.ArticleService;
import fan.utils.BlogMapStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章管理实现类
 *
 * @author Fan
 * @since 2023/6/9 15:14
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDAO articleDAO;

    @Override
    public Response<Page<ArticleVO>> pageArticles(ArticleQuery articleQuery) {
        try {
            LambdaQueryWrapper<ArticleDO> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.eq(StringUtil.INSTANCE.isNotBlank(articleQuery.getCategoryId()), ArticleDO::getCategoryId, articleQuery.getCategoryId())
                    .like(StringUtil.INSTANCE.isNotBlank(articleQuery.getTitle()), ArticleDO::getTitle, articleQuery.getTitle())
                    // 设置查询的字段, 过滤掉不需要的数据
                    .select(ArticleDO.class, tableFieldInfo -> !"content".equals(tableFieldInfo.getColumn()));

            Page<ArticleDO> page = articleDAO.selectPage(new Page<>(articleQuery.getCurrentPage(), articleQuery.getPageSize()), queryWrapper);
            return Response.success(BlogMapStruct.INSTANCE.transArticle(page));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询文章出现异常!", null);
        }
    }

    @Override
    public Response<ArticleVO> getArticle(String id) {
        try {
            ArticleDO articleDO = articleDAO.selectOne(new LambdaQueryWrapper<ArticleDO>().eq(ArticleDO::getId, id));
            ArticleVO articleVO = BlogMapStruct.INSTANCE.transArticle(articleDO);
            articleVO.setContent(articleDO.getContent());
            return Response.success(articleVO);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("获取文章出现异常!", null);
        }
    }

    @Override
    public Response<String> saveArticle(ArticleDTO articleDTO) {
        try {
            if (StringUtil.INSTANCE.isBlank(articleDTO.getId())) {
                ArticleDO articleDO = BlogMapStruct.INSTANCE.transArticle(articleDTO);

                String snowflakeId = String.valueOf(IdUtil.getSnowflakeId());

                articleDO.setId(snowflakeId);
                articleDO.setFlag("Y");

                if (StringUtil.INSTANCE.isBlank(articleDO.getCategoryId())) {
                    articleDO.setCategoryId("14151607879553024");
                }

                LocalDateTime localDateTime = LocalDateTime.now();
                articleDO.setCreateTime(Timestamp.valueOf(localDateTime));
                articleDO.setUpdateTime(Timestamp.valueOf(localDateTime));

                articleDAO.insert(articleDO);
                return Response.success(snowflakeId);
            }

            return updateArticle(articleDTO);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("保存文章出现异常!", null);
        }
    }

    private Response<String> updateArticle(ArticleDTO articleDTO) {
        ArticleDO articleDO = BlogMapStruct.INSTANCE.transArticle(articleDTO);
        articleDO.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        articleDAO.updateById(articleDO);
        return Response.success(articleDO.getId());
    }

    @Override
    public Response<Integer> deleteArticle(List<String> ids) {
        try {
            return Response.success(articleDAO.deleteBatchIds(ids));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("删除文章出现异常!", null);
        }
    }
}
