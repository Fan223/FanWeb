package fan.pojo.dto;

import lombok.Data;

/**
 * 用户更新参数
 *
 * @author Fan
 * @since 2023/6/9 14:46
 */
@Data
public class UserDTO {

    private String id;

    private String username;

    private String password;

    private String avatar;

    private String flag;
}
