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

    /**
     * 获取材料列表
     *
     * @param menuQuery 菜单查询参数
     * @return {@link Response<Map<String,List<MenuVO>>>}
     * @author Fan
     * @since 2023/7/10 14:19
     */
    Response<Map<String, List<MenuVO>>> listMenus(MenuQuery menuQuery);

    /**
     * 查询子菜单
     *
     * @param id ID
     * @return {@link Response<List<MenuVO>>}
     * @author Fan
     * @since 2023/6/13 9:01
     */
    Response<List<MenuVO>> listChildMenus(String id);

    /**
     * 查询顶层父菜单的子菜单
     *
     * @param id ID
     * @return {@link Response<Map>}
     * @author Fan
     * @since 2023/6/14 14:44
     */
    Response<Map> listTopChildMenus(String id);

    /**
     * 添加菜单
     *
     * @param menuDTO 菜单更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:20
     */
    Response<Integer> addMenu(MenuDTO menuDTO);

    /**
     * 修改参数
     *
     * @param menuDTO 菜单更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:20
     */
    Response<Integer> updateMenu(MenuDTO menuDTO);

    /**
     * 删除菜单
     *
     * @param ids ID列表
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:20
     */
    Response<Integer> deleteMenu(List<String> ids);
}
