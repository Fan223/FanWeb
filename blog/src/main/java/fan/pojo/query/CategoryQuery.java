package fan.pojo.query;

import fan.query.BaseQuery;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类查询参数
 *
 * @author Fan
 * @since 2023/6/9 16:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class CategoryQuery extends BaseQuery {

    private String id;

    private String name;

    private String flag;
}
