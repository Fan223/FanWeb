package fan.service.impl.impl;

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
    public Response page(Query query) {
        try {
            ArticleQuery articleQuery = (ArticleQuery) query;
            LambdaQueryWrapper<ArticleDO> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.eq(StringUtil.INSTANCE.isNotBlank(articleQuery.getCategoryId()), ArticleDO::getCategoryId, articleQuery.getCategoryId())
                    .like(StringUtil.INSTANCE.isNotBlank(articleQuery.getTitle()), ArticleDO::getTitle, articleQuery.getTitle());

            Page<ArticleDO> page = articleDAO.selectPage(new Page<>(articleQuery.getCurrentPage(), articleQuery.getPageSize()), queryWrapper);
            return Response.success(BlogMapStruct.INSTANCE.transArticle(page));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询文章出现异常!");
        }
    }

    @Override
    public Response get(String id) {
        try {
            ArticleDO articleDO = articleDAO.selectOne(new LambdaQueryWrapper<ArticleDO>().eq(ArticleDO::getId, id));
            ArticleVO articleVO = BlogMapStruct.INSTANCE.transArticle(articleDO);
            articleVO.setContent(articleDO.getContent());
            return Response.success(articleVO);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("获取文章出现异常!");
        }
    }

    @Override
    public Response insert(Insert insert) {
        try {
            ArticleDTO articleDTO = (ArticleDTO) insert;

            if (StringUtil.INSTANCE.isBlank(articleDTO.getId())) {
                ArticleDO articleDO = BlogMapStruct.INSTANCE.transArticle(articleDTO);

                long snowflakeId = IdUtil.getSnowflakeId();
                articleDO.setId(String.valueOf(snowflakeId));
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

            return update(articleDTO);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("保存文章出现异常!");
        }
    }

    @Override
    public Response update(Update update) {
        ArticleDO articleDO = BlogMapStruct.INSTANCE.transArticle((ArticleDTO) update);
        articleDO.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        articleDAO.updateById(articleDO);
        return Response.success(articleDO.getId());
    }

    @Override
    public Response delete(List<String> ids) {
        try {
            return Response.success(articleDAO.deleteBatchIds(ids));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("删除文章出现异常!");
        }
    }
}
