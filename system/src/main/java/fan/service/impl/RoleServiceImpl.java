package fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.dao.RoleDAO;
import fan.lang.Query;
import fan.lang.Response;
import fan.lang.StringUtil;
import fan.pojo.entity.RoleDO;
import fan.pojo.query.RoleQuery;
import fan.service.RoleService;
import fan.utils.SysMapStruct;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色管理实现类
 *
 * @author Fan
 * @since 2023/6/19 10:32
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDAO roleDAO;

    @Override
    public Response page(Query query) {
        RoleQuery roleQuery = (RoleQuery) query;
        LambdaQueryWrapper<RoleDO> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(StringUtil.INSTANCE.isNotBlank(roleQuery.getFlag()), RoleDO::getFlag, roleQuery.getFlag())
                .like(StringUtil.INSTANCE.isNotBlank(roleQuery.getName()), RoleDO::getName, roleQuery.getName());

        Page<RoleDO> rolePage = roleDAO.selectPage(new Page<>(roleQuery.getCurrentPage(), roleQuery.getPageSize()), queryWrapper);
        return Response.success(SysMapStruct.INSTANCE.transRole(rolePage));
    }
}
