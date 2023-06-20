package fan.controller;

import fan.lang.Response;
import fan.pojo.dto.RoleDTO;
import fan.pojo.query.RoleQuery;
import fan.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/addRole")
    public Response addRole(@RequestBody RoleDTO roleDTO) {
        return roleService.insert(roleDTO);
    }

    @PutMapping("/updateRole")
    public Response updateRole(@RequestBody RoleDTO roleDTO) {
        return roleService.update(roleDTO);
    }

    @DeleteMapping("/deleteRole/{id}")
    public Response deleteRole(@PathVariable("id") List<String> ids) {
        return roleService.delete(ids);
    }
}
