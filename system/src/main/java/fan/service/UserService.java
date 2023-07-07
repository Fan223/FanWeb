package fan.service;

import fan.lang.BaseService;
import fan.lang.Response;
import fan.pojo.entity.UserDO;
import fan.pojo.vo.UserVO;

/**
 * 用户管理接口
 *
 * @author Fan
 * @since 2023/6/9 14:24
 */
public interface UserService extends BaseService {

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
}
