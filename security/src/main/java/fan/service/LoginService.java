package fan.service;

import fan.dto.LoginDTO;
import fan.lang.Response;

/**
 * 登录接口
 *
 * @author Fan
 * @since 2023/7/7 15:14
 */
public interface LoginService {

    /**
     * 获取验证码
     *
     * @return {@link Response}
     * @author Fan
     * @since 2023/7/7 15:20
     */
    Response getCaptcha();

    /**
     * 登录校验
     *
     * @param loginDTO 登录参数
     * @return {@link Response}
     * @author Fan
     * @since 2023/7/7 15:17
     */
    Response login(LoginDTO loginDTO);
}
