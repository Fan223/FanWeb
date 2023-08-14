package fan.controller;

import fan.core.util.ListUtil;
import fan.lang.Response;
import fan.pojo.dto.MenuDTO;
import fan.pojo.query.MenuQuery;
import fan.pojo.vo.MenuVO;
import fan.service.MenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理 Controller
 *
 * @author Fan
 * @since 2023/6/9 11:12
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping("/listNavMenus")
    public Response<Map<String, List<MenuVO>>> listNavMenus(MenuQuery menuQuery) {
        menuQuery.setFlag("Y");
        menuQuery.setType(ListUtil.list(1, 2, 4));
        return menuService.listMenus(menuQuery);
    }

    @GetMapping("/listChildMenus/{id}")
    public Response<List<MenuVO>> listChildMenus(@PathVariable("id") String id) {
        return menuService.listChildMenus(id);
    }

    @GetMapping("/listTopChildMenus/{id}")
    public Response<Map> listTopChildMenus(@PathVariable("id") String id) {
        return menuService.listTopChildMenus(id);
    }

    @GetMapping("/listMenus")
    public Response<Map<String, List<MenuVO>>> listMenus(MenuQuery menuQuery) {
        return menuService.listMenus(menuQuery);
    }

    @PostMapping("/addMenu")
    public Response<Integer> addMenu(@RequestBody MenuDTO menuDTO) {
        return menuService.addMenu(menuDTO);
    }

    @PutMapping("/updateMenu")
    public Response<Integer> updateMenu(@RequestBody MenuDTO menuDTO) {
        return menuService.updateMenu(menuDTO);
    }

    @DeleteMapping("/deleteMenu/{id}")
    public Response<Integer> deleteMenu(@PathVariable("id") List<String> ids) {
        return menuService.deleteMenu(ids);
    }
}
