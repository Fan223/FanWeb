package fan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.UserDTO;
import fan.pojo.query.UserQuery;
import fan.pojo.vo.UserVO;
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
    public Response<Page<UserVO>> pageUsers(UserQuery userQuery) {
        return userService.pageUsers(userQuery);
    }

    @GetMapping("/getUser/{username}")
    public Response<UserVO> getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @PostMapping("/addUser")
    public Response<Integer> addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PutMapping("/updateUser")
    public Response<Integer> updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Response<Integer> deleteUser(@PathVariable("id") List<String> ids) {
        return userService.deleteUser(ids);
    }
}
