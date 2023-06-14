package fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import fan.core.util.CollectionUtil;
import fan.core.util.IdUtil;
import fan.core.util.ListUtil;
import fan.core.util.MapUtil;
import fan.dao.MenuDAO;
import fan.lang.*;
import fan.pojo.dto.MenuDTO;
import fan.pojo.entity.MenuDO;
import fan.pojo.query.MenuQuery;
import fan.pojo.vo.MenuVO;
import fan.service.MenuService;
import fan.utils.SysMapStruct;
import fan.utils.SysUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单管理实现类
 *
 * @author Fan
 * @since 2023/6/9 11:15
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDAO menuDAO;

    @Override
    public Response list(Query query) {
        try {
            MenuQuery menuQuery = (MenuQuery) query;
            LambdaQueryWrapper<MenuDO> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.eq(StringUtil.INSTANCE.isNotBlank(menuQuery.getFlag()), MenuDO::getFlag, menuQuery.getFlag())
                    .eq(StringUtil.INSTANCE.isNotBlank(menuQuery.getPosition()), MenuDO::getPosition, menuQuery.getPosition())
                    .in(CollectionUtil.isNotEmpty(menuQuery.getType()), MenuDO::getType, menuQuery.getType())
                    .like(StringUtil.INSTANCE.isNotBlank(menuQuery.getName()), MenuDO::getName, menuQuery.getName())
                    .orderByAsc(MenuDO::getOrderNum);
            List<MenuVO> menuVos = SysMapStruct.INSTANCE.transMenu(menuDAO.selectList(queryWrapper));
            List<MenuVO> topMenuVos = menuVos.stream().filter(menuVO -> "top".equals(menuVO.getPosition())).map(MenuVO::new).collect(Collectors.toList());

            return Response.success(MapUtil.builder().put("top", SysUtil.buildTree(topMenuVos))
                    .put("aside", SysUtil.buildTree(menuVos)).build());
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询菜单出现异常!");
        }
    }

    @Override
    public Response listChildMenus(String id) {
        try {
            List<MenuDO> childMenus = menuDAO.listChildMenus(id);
            return Response.success(SysUtil.buildTree(SysMapStruct.INSTANCE.transMenu(childMenus)));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询侧栏菜单出现异常!");
        }
    }

    @Override
    public Response listTopChildMenus(String id) {
        try {
            String topMenuId = menuDAO.getTopParentMenu(id);
            List<MenuVO> childMenus = ListUtil.castToList(MenuVO.class, listChildMenus(topMenuId).getData());
            return Response.success(MapUtil.builder().put("topMenuId", topMenuId).put("childMenus", childMenus).build());
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询顶层父菜单的子菜单出现异常!");
        }

    }

    @Override
    public Response insert(Insert insert) {
        try {
            MenuDO menuDO = SysMapStruct.INSTANCE.transMenu((MenuDTO) insert);

            menuDO.setId(String.valueOf(IdUtil.getSnowflakeId()));
            if (StringUtil.INSTANCE.isBlank(menuDO.getIcon())) {
                menuDO.setIcon(null);
            }

            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            menuDO.setCreateTime(timestamp);
            menuDO.setUpdateTime(timestamp);

            return Response.success(menuDAO.insert(menuDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("新增菜单出现异常!");
        }
    }

    @Override
    public Response update(Update update) {
        try {
            MenuDO menuDO = SysMapStruct.INSTANCE.transMenu((MenuDTO) update);

            if (StringUtil.INSTANCE.isBlank(menuDO.getIcon())) {
                menuDO.setIcon(null);
            }
            menuDO.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));

            return Response.success(menuDAO.updateById(menuDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("更新菜单出现异常!");
        }
    }

    @Override
    public Response delete(List<String> ids) {
        try {
            return Response.success(menuDAO.deleteBatchIds(ids));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("删除菜单出现异常!");
        }
    }
}
