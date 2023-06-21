package fan.pojo.query;

import fan.query.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 标签查询参数
 *
 * @author Fan
 * @since 2023/6/21 13:55
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TagQuery extends BaseQuery {

    private String name;

    private String flag;
}
