package fan.pojo.query;

import fan.query.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询参数
 *
 * @author Fan
 * @since 2023/6/9 14:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends BaseQuery {

    private String name;

    private String flag;
}
