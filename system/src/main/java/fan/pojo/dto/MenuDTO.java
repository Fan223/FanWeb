package fan.pojo.dto;

import fan.lang.Insert;
import fan.lang.Update;
import lombok.Data;

/**
 * 菜单更新参数
 *
 * @author Fan
 * @since 2023/6/9 11:17
 */
@Data
public class MenuDTO implements Insert, Update {

    private String id;

    private String parentId;

    private String position;

    private String name;

    private String path;

    private String permission;

    private String component;

    private Integer type;

    private String icon;

    private Integer orderNum;

    private String flag;
}
