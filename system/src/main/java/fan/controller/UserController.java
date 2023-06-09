package fan.controller;

import fan.lang.Response;
import fan.pojo.dto.UserDTO;
import fan.pojo.query.UserQuery;
import fan.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理 Controller
 *
 * @author Fan
 * @since 2023/6/9 14:23
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/pageUsers")
    public Response pageUsers(UserQuery userQuery) {
        return userService.page(userQuery);
    }

    @PostMapping("/addUser")
    public Response addUser(@RequestBody UserDTO userDTO) {
        return userService.insert(userDTO);
    }

    @PutMapping("/updateUser")
    public Response updateUser(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Response deleteUser(@PathVariable("id") List<String> ids) {
        return userService.delete(ids);
    }
}
