package fan.service;

import fan.lang.BaseService;
import fan.lang.Response;

/**
 * 菜单管理接口
 *
 * @author Fan
 * @since 2023/6/9 11:13
 */
public interface MenuService extends BaseService {

    /**
     * 查询子菜单
     *
     * @param id ID
     * @return {@link Response}
     * @author Fan
     * @since 2023/6/13 9:01
     */
    Response listChildMenus(String id);
}
