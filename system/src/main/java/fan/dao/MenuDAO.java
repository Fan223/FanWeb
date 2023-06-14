package fan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fan.lang.Response;
import fan.pojo.entity.MenuDO;

import java.util.List;

/**
 * 菜单管理 DAO
 *
 * @author Fan
 * @since 2023/6/9 11:15
 */
public interface MenuDAO extends BaseMapper<MenuDO> {

    /**
     * 查询子菜单
     *
     * @param id ID
     * @return {@link Response}
     * @author Fan
     * @since 2023/6/13 9:02
     */
    List<MenuDO> listChildMenus(String id);

    /**
     * 查询顶层父菜单
     *
     * @param id ID
     * @return {@link MenuDO}
     * @author Fan
     * @since 2023/6/14 14:46
     */
    String getTopParentMenu(String id);
}
