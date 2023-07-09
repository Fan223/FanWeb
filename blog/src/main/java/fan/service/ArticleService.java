package fan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.ArticleDTO;
import fan.pojo.query.ArticleQuery;
import fan.pojo.vo.ArticleVO;

import java.util.List;

/**
 * 文章管理接口
 *
 * @author Fan
 * @since 2023/6/9 15:13
 */
public interface ArticleService {

    /**
     * 分页获取文章
     *
     * @param articleQuery 文章查询参数
     * @return {@link Response}
     * @author Fan
     * @since 2023/7/8 1:54
     */

    Response<Page<ArticleVO>> pageArticles(ArticleQuery articleQuery);

    /**
     * 获取文章
     *
     * @param id ID
     * @return {@link Response}
     * @author Fan
     * @since 2023/7/8 1:55
     */

    Response<ArticleVO> getArticle(String id);

    /**
     * 保存文章
     *
     * @param articleDTO 文章更新参数
     * @return {@link Response}
     * @author Fan
     * @since 2023/7/8 1:56
     */
    Response<String> saveArticle(ArticleDTO articleDTO);

    /**
     * 删除文章
     *
     * @param ids ID列表
     * @return {@link Response}
     * @author Fan
     * @since 2023/7/8 2:00
     */
    Response<Integer> deleteArticle(List<String> ids);
}
