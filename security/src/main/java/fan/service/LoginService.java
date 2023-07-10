package fan.service;

import fan.dto.LoginDTO;
import fan.lang.Response;
import fan.pojo.vo.UserVO;

import java.util.Map;

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
    Response<Map<String, String>> getCaptcha();

    /**
     * 登录校验
     *
     * @param loginDTO 登录参数
     * @return {@link Response}
     * @author Fan
     * @since 2023/7/7 15:17
     */
    Response<UserVO> login(LoginDTO loginDTO);
}
