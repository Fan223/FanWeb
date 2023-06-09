package fan.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.pojo.dto.MenuDTO;
import fan.pojo.dto.UserDTO;
import fan.pojo.entity.MenuDO;
import fan.pojo.entity.UserDO;
import fan.pojo.vo.MenuVO;
import fan.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 系统管理转换类
 *
 * @author Fan
 * @since 2023/6/9 13:53
 */
@Mapper
public interface SysMapStruct {

    SysMapStruct INSTANCE = Mappers.getMapper(SysMapStruct.class);

    /**
     * 菜单实体类转展示类
     *
     * @param menuDO 菜单实体类
     * @return {@link MenuVO}
     * @author Fan
     * @since 2023/6/9 13:54
     */
    @Mapping(target = "createTime", source = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    MenuVO transMenu(MenuDO menuDO);

    /**
     * 菜单实体类列表转展示类列表
     *
     * @param menuDos 菜单实体类列表
     * @return {@link List<MenuVO>}
     * @author Fan
     * @since 2023/6/9 13:55
     */
    List<MenuVO> transMenu(List<MenuDO> menuDos);

    /**
     * 菜单更新参数转实体类
     *
     * @param menuDTO 菜单更新参数
     * @return {@link MenuDO}
     * @author Fan
     * @since 2023/6/9 13:55
     */
    MenuDO transMenu(MenuDTO menuDTO);

    /**
     * 用户实体类转展示类
     *
     * @param userDO 用户实体类
     * @return {@link UserVO}
     * @author Fan
     * @since 2023/6/9 14:50
     */
    @Mapping(target = "createTime", source = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVO transUser(UserDO userDO);

    /**
     * 用户实体类列表转展示类列表
     *
     * @param userDos 用户实体类列表
     * @return {@link List<UserVO>}
     * @author Fan
     * @since 2023/6/9 14:50
     */
    List<UserVO> transUser(List<UserDO> userDos);

    /**
     * 用户实体类分页转展示类分页
     *
     * @param userPage 用户实体类分页
     * @return {@link Page<UserVO>}
     * @author Fan
     * @since 2023/6/9 14:51
     */
    Page<UserVO> transUser(Page<UserDO> userPage);

    /**
     * 用户更新参数转实体类
     *
     * @param userDTO 用户更新参数
     * @return {@link UserDO}
     * @author Fan
     * @since 2023/6/9 14:51
     */
    UserDO transUser(UserDTO userDTO);
}
