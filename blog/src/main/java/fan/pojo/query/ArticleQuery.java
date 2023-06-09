package fan.pojo.query;

import fan.query.BaseQuery;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章查询参数
 *
 * @author Fan
 * @since 2023/6/9 15:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class ArticleQuery extends BaseQuery {

    private String id;

    private String title;

    private String categoryId;
}
