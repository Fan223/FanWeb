package fan.controller;

import fan.core.util.BaseUtil;
import fan.lang.Calculator;
import fan.lang.Response;
import org.springframework.web.bind.annotation.*;

/**
 * 工具 Controller
 *
 * @author Fan
 * @since 2023/7/3 15:11
 */
@RestController
@RequestMapping("/tool")
public class ToolController {

    @GetMapping("/calculate")
    public Response calculate(String equation) {
        try {
            return Response.success(Calculator.calculate(equation));
        } catch (RuntimeException e) {
            return Response.fail(e.getMessage(), null);
        }
    }

    @PostMapping("/format")
    public Response format(@RequestBody String json) {
        return Response.success(BaseUtil.formatJson(json));
    }
}
