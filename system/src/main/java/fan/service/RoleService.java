package fan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.RoleDTO;
import fan.pojo.query.RoleQuery;
import fan.pojo.vo.RoleVO;

import java.util.List;

/**
 * 角色管理接口
 *
 * @author Fan
 * @since 2023/6/19 10:31
 */
public interface RoleService {
    Response<Page<RoleVO>> pageRoles(RoleQuery roleQuery);

    Response<Integer> addRole(RoleDTO roleDTO);

    Response<Integer> updateRole(RoleDTO roleDTO);

    Response<Integer> deleteRole(List<String> ids);
}
