package fan.pojo.dto;

import lombok.Data;

/**
 * 用户更新参数
 *
 * @author Fan
 * @since 2023/6/19 10:43
 */
@Data
public class RoleDTO {

    private String id;

    private String code;

    private String name;

    private String remark;

    private String flag;
}
