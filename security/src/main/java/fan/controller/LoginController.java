package fan.controller;

import fan.dto.LoginDTO;
import fan.lang.Response;
import fan.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登录管理 Controller
 *
 * @author Fan
 * @since 2023/6/9 15:10
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/getCaptcha")
    public Response getCaptcha() {
        return loginService.getCaptcha();
    }

    @PostMapping("/login")
    public Response login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
