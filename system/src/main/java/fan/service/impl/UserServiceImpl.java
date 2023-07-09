package fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.core.util.IdUtil;
import fan.dao.UserDAO;
import fan.lang.*;
import fan.pojo.dto.UserDTO;
import fan.pojo.entity.UserDO;
import fan.pojo.query.UserQuery;
import fan.pojo.vo.UserVO;
import fan.service.UserService;
import fan.utils.SysMapStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户管理实现类
 *
 * @author Fan
 * @since 2023/6/9 14:25
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public Response<Page<UserVO>> pageUsers(UserQuery userQuery) {
        try {
            LambdaQueryWrapper<UserDO> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.eq(StringUtil.INSTANCE.isNotBlank(userQuery.getFlag()), UserDO::getFlag, userQuery.getFlag())
                    .like(StringUtil.INSTANCE.isNotBlank(userQuery.getUsername()), UserDO::getUsername, userQuery.getUsername());

            Page<UserDO> page = userDAO.selectPage(new Page<>(userQuery.getCurrentPage(), userQuery.getPageSize()), queryWrapper);
            return Response.success(SysMapStruct.INSTANCE.transUser(page));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询用户出现异常!", null);
        }
    }

    @Override
    public Response<Integer> addUser(UserDTO userDTO) {
        try {
            if (null != getUser(userDTO.getUsername()).getData()) {
                return Response.fail("用户名已存在", null);
            }

            UserDO userDO = SysMapStruct.INSTANCE.transUser(userDTO);
            userDO.setId(String.valueOf(IdUtil.getSnowflakeId()));

            LocalDateTime localDateTime = LocalDateTime.now();
            userDO.setCreateTime(Timestamp.valueOf(localDateTime));
            userDO.setUpdateTime(Timestamp.valueOf(localDateTime));

            return Response.success(userDAO.insert(userDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("新增用户出现异常!", null);
        }
    }

    @Override
    public Response<UserVO> getUser(String username) {
        return Response.success("获取用户成功", SysMapStruct.INSTANCE.transUser(verifyUser(username)));
    }

    @Override
    public UserDO verifyUser(String username) {
        return userDAO.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, username));
    }

    @Override
    public Response<Integer> updateUser(UserDTO userDTO) {
        try {
            UserDO user = verifyUser(userDTO.getUsername());
            if (null != user && !user.getId().equals(userDTO.getId())) {
                return Response.fail("用户名重复", null);
            }

            UserDO userDO = SysMapStruct.INSTANCE.transUser(userDTO);
            userDO.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
            return Response.success(userDAO.updateById(userDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("更新用户出现异常!", null);
        }
    }

    @Override
    public Response<Integer> deleteUser(List<String> ids) {
        try {
            return Response.success(userDAO.deleteBatchIds(ids));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("删除用户出现异常!", null);
        }
    }
}
