package fan.dto;

import lombok.Data;

/**
 * 登录参数
 *
 * @author Fan
 * @since 2023/7/7 15:12
 */
@Data
public class LoginDTO {

    private String token;

    private String captcha;

    private String username;

    private String password;
}
