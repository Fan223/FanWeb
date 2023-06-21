package fan.pojo.dto;

import fan.lang.Insert;
import fan.lang.Update;
import lombok.Data;

/**
 * 标签更新参数
 *
 * @author Fan
 * @since 2023/6/21 13:54
 */
@Data
public class TagDTO implements Insert, Update {

    private String id;

    private String name;

    private String flag;
}
