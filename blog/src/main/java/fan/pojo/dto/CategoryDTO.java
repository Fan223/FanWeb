package fan.pojo.dto;

import fan.lang.Insert;
import fan.lang.Update;
import lombok.Data;

/**
 * 分类更新参数
 *
 * @author Fan
 * @since 2023/6/9 16:06
 */
@Data
public class CategoryDTO implements Insert, Update {

    private String id;

    private String name;

    private String remark;

    private String flag;
}
