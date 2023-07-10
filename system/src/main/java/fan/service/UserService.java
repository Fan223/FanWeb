package fan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.UserDTO;
import fan.pojo.entity.UserDO;
import fan.pojo.query.UserQuery;
import fan.pojo.vo.UserVO;

import java.util.List;

/**
 * 用户管理接口
 *
 * @author Fan
 * @since 2023/6/9 14:24
 */
public interface UserService {

    /**
     * 分页获取用户
     *
     * @param userQuery 用户更新参数
     * @return {@link Response<Page<UserVO>>}
     * @author Fan
     * @since 2023/7/10 14:23
     */
    Response<Page<UserVO>> pageUsers(UserQuery userQuery);

    /**
     * 添加用户
     *
     * @param userDTO 用户更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:23
     */
    Response<Integer> addUser(UserDTO userDTO);

    /**
     * 获取用户
     *
     * @param username 用户名
     * @return {@link UserDO}
     * @author Fan
     * @since 2023/7/7 15:29
     */
    Response<UserVO> getUser(String username);

    /**
     * 验证用户
     *
     * @param username 用户名
     * @return {@link UserDO}
     * @author Fan
     * @since 2023/7/7 16:08
     */
    UserDO verifyUser(String username);

    /**
     * 修改用户
     *
     * @param userDTO 用户更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:24
     */
    Response<Integer> updateUser(UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param ids ID列表
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:24
     */
    Response<Integer> deleteUser(List<String> ids);
}
