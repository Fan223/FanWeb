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

    /**
     * 分页获取角色
     *
     * @param roleQuery 角色查询参数
     * @return {@link Response<Page<RoleVO>>}
     * @author Fan
     * @since 2023/7/10 14:22
     */
    Response<Page<RoleVO>> pageRoles(RoleQuery roleQuery);

    /**
     * 添加角色
     *
     * @param roleDTO 角色更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:23
     */
    Response<Integer> addRole(RoleDTO roleDTO);

    /**
     * 修改角色
     *
     * @param roleDTO 角色更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:23
     */
    Response<Integer> updateRole(RoleDTO roleDTO);

    /**
     * 删除角色
     *
     * @param ids ID列表
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:23
     */
    Response<Integer> deleteRole(List<String> ids);
}
