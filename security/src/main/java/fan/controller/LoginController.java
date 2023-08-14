package fan.controller;

import fan.dto.LoginDTO;
import fan.lang.Response;
import fan.pojo.vo.UserVO;
import fan.service.LoginService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.Map;

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
    public Response<Map<String, String>> getCaptcha() {
        return loginService.getCaptcha();
    }

    @PostMapping("/login")
    public Response<UserVO> login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
