package fan.controller;

import fan.captcha.CaptchaUtil;
import fan.lang.Response;
import org.springframework.web.bind.annotation.*;

/**
 * 登录管理 Controller
 *
 * @author Fan
 * @since 2023/6/9 15:10
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @GetMapping("/getCaptcha")
    public Response getCaptcha() {
        return Response.success(CaptchaUtil.getKaptcha());
    }
}
