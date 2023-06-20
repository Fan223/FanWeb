package fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.core.util.IdUtil;
import fan.dao.RoleDAO;
import fan.lang.*;
import fan.pojo.dto.MenuDTO;
import fan.pojo.dto.RoleDTO;
import fan.pojo.entity.MenuDO;
import fan.pojo.entity.RoleDO;
import fan.pojo.query.RoleQuery;
import fan.service.RoleService;
import fan.utils.SysMapStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 角色管理实现类
 *
 * @author Fan
 * @since 2023/6/19 10:32
 */
@Service
@Slf4j
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

    @Override
    public Response insert(Insert insert) {
        try {
            RoleDO roleDO = SysMapStruct.INSTANCE.transRole((RoleDTO) insert);

            roleDO.setId(String.valueOf(IdUtil.getSnowflakeId()));
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            roleDO.setCreateTime(timestamp);
            roleDO.setUpdateTime(timestamp);

            return Response.success(roleDAO.insert(roleDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("新增角色出现异常!");
        }
    }

    @Override
    public Response update(Update update) {
        try {
            RoleDO roleDO = SysMapStruct.INSTANCE.transRole((RoleDTO) update);
            roleDO.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
            return Response.success(roleDAO.updateById(roleDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("更新角色出现异常!");
        }
    }

    @Override
    public Response delete(List<String> ids) {
        try {
            return Response.success(roleDAO.deleteBatchIds(ids));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("删除角色出现异常!");
        }
    }
}
