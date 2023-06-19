package fan.pojo.vo;

import lombok.Data;

/**
 * 角色展示类
 *
 * @author Fan
 * @since 2023/6/19 10:42
 */
@Data
public class RoleVO {

    private String id;

    private String code;

    private String name;

    private String remark;

    private String flag;

    private String createTime;
}
