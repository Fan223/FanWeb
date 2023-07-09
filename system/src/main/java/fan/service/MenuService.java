package fan.service;

import fan.lang.Response;
import fan.pojo.dto.MenuDTO;
import fan.pojo.query.MenuQuery;
import fan.pojo.vo.MenuVO;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理接口
 *
 * @author Fan
 * @since 2023/6/9 11:13
 */
public interface MenuService {

    Response<Map<String, List<MenuVO>>> listMenus(MenuQuery menuQuery);

    /**
     * 查询子菜单
     *
     * @param id ID
     * @return {@link Response}
     * @author Fan
     * @since 2023/6/13 9:01
     */
    Response<List<MenuVO>> listChildMenus(String id);

    /**
     * 查询顶层父菜单的子菜单
     *
     * @param id ID
     * @return {@link Response}
     * @author Fan
     * @since 2023/6/14 14:44
     */
    Response listTopChildMenus(String id);

    Response<Integer> addMenu(MenuDTO menuDTO);

    Response<Integer> updateMenu(MenuDTO menuDTO);

    Response<Integer> deleteMenu(List<String> ids);
}
