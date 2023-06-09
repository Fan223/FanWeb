package fan.utils;

import fan.core.util.CollectionUtil;
import fan.pojo.vo.MenuVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 系统工具类
 *
 * @author Fan
 * @since 2023/6/9 14:02
 */
public class SysUtil {

    private SysUtil() {
    }

    public static List<MenuVO> buildTree(List<MenuVO> menuVos) {
        if (CollectionUtil.isEmpty(menuVos)) {
            return new ArrayList<>();
        }
        List<MenuVO> menusTree = new ArrayList<>(menuVos.size());

        // 先将菜单列表转为 Map, Key 为ID
        Map<String, MenuVO> menuVoMap = menuVos.stream().collect(Collectors.toMap(MenuVO::getId, menuVO -> menuVO));

        // 循环菜单列表
        for (MenuVO menuVO : menuVos) {
            // 判断当前菜单是否有父菜单
            MenuVO parentMenuVO = menuVoMap.get(menuVO.getParentId());

            // 父菜单为空则当前菜单为顶级菜单, 直接加入结果列表
            if (null == parentMenuVO) {
                menusTree.add(menuVO);
                continue;
            }

            // 不为空则将当前菜单添加到获取到的父菜单的子菜单
            parentMenuVO.getChildren().add(menuVO);
        }

        return menusTree;
    }
}
