package fan.pojo.query;

import fan.query.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色查询参数
 *
 * @author Fan
 * @since 2023/6/19 10:43
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleQuery extends BaseQuery {

    private String name;

    private String flag;
}
