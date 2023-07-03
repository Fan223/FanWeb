package fan.controller;

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
    public Response calculate(String expression) {
        try {
            return Response.success(Calculator.calculate(expression));
        } catch (RuntimeException e) {
            return Response.fail(e.getMessage(), null);
        }
    }
}
