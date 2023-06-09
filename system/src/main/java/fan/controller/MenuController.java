package fan.controller;

import fan.core.util.ListUtil;
import fan.lang.Response;
import fan.pojo.dto.MenuDTO;
import fan.pojo.query.MenuQuery;
import fan.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public Response listNavMenus() {
        return menuService.list(MenuQuery.builder().type(ListUtil.list(1, 2)).flag("Y").build());
    }

    @GetMapping("/listMenus")
    public Response listMenus(MenuQuery menuQuery) {
        return menuService.list(menuQuery);
    }

    @PostMapping("/addMenu")
    public Response addMenu(@RequestBody MenuDTO menuDTO) {
        return menuService.insert(menuDTO);
    }

    @PutMapping("/updateMenu")
    public Response updateMenu(@RequestBody MenuDTO menuDTO) {
        return menuService.update(menuDTO);
    }

    @DeleteMapping("/deleteMenu/{id}")
    public Response delete(@PathVariable("id") List<String> ids) {
        return menuService.delete(ids);
    }
}
