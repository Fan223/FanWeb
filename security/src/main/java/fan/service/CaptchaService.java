package fan.service;

import fan.lang.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 验证码接口
 *
 * @author Fan
 * @since 2023/7/7 14:15
 */
@FeignClient(value = "fan-captcha")
public interface CaptchaService {

    /**
     * 获取验证码及图片
     *
     * @param server 服务
     * @return {@link Response<Map<String,String>>}
     * @author Fan
     * @since 2023/7/7 14:18
     */
    @GetMapping("/getCaptcha")
    Response<Map<String, String>> getCaptcha(@RequestParam("server") String server);

    /**
     * 校验验证码
     *
     * @param token   token
     * @param captcha 验证码
     * @return {@link Response<Boolean>}
     * @author Fan
     * @since 2023/7/7 14:18
     */
    @PostMapping("/verifyCaptcha")
    Response<Boolean> verifyCaptcha(@RequestParam("token") String token,
                                    @RequestParam("captcha") String captcha);
}
