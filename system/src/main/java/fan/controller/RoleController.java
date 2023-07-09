package fan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.RoleDTO;
import fan.pojo.query.RoleQuery;
import fan.pojo.vo.RoleVO;
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
    public Response<Page<RoleVO>> pageRoles(RoleQuery roleQuery) {
        return roleService.pageRoles(roleQuery);
    }

    @PostMapping("/addRole")
    public Response<Integer> addRole(@RequestBody RoleDTO roleDTO) {
        return roleService.addRole(roleDTO);
    }

    @PutMapping("/updateRole")
    public Response<Integer> updateRole(@RequestBody RoleDTO roleDTO) {
        return roleService.updateRole(roleDTO);
    }

    @DeleteMapping("/deleteRole/{id}")
    public Response<Integer> deleteRole(@PathVariable("id") List<String> ids) {
        return roleService.deleteRole(ids);
    }
}
