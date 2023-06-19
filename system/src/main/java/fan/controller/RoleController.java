package fan.controller;

import fan.lang.Response;
import fan.pojo.query.RoleQuery;
import fan.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色管理 Controller
 *
 * @author Fan
 * @since 2023/6/19 10:30
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/pageRoles")
    public Response pageRoles(RoleQuery roleQuery) {
        return roleService.page(roleQuery);
    }
}
