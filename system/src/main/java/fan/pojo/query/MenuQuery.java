package fan.pojo.query;

import fan.lang.Query;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 菜单查询参数
 *
 * @author Fan
 * @since 2023/6/9 11:16
 */
@Data
@Builder
public class MenuQuery implements Query {

    private String name;

    private List<Integer> type;

    private String flag;
}
