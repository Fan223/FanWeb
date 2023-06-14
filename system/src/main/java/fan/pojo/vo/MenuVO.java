package fan.pojo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单展示类
 *
 * @author Fan
 * @since 2023/6/9 11:17
 */
@Data
@NoArgsConstructor
public class MenuVO {

    private String id;

    private String parentId;

    private String position;

    private String name;

    private String path;

    private String permission;

    private String component;

    private Integer type;

    private String icon;

    private Integer orderNum;

    private String flag;

    private String createTime;

    private List<MenuVO> children;

    public List<MenuVO> getChildren() {
        if (null == children) {
            children = new ArrayList<>();
        }
        return children;
    }

    public MenuVO(MenuVO menuVO) {
        this.id = menuVO.id;
        this.parentId = menuVO.parentId;
        this.position = menuVO.position;
        this.name = menuVO.name;
        this.path = menuVO.path;
        this.permission = menuVO.permission;
        this.component = menuVO.component;
        this.type = menuVO.type;
        this.icon = menuVO.icon;
        this.orderNum = menuVO.orderNum;
        this.flag = menuVO.flag;
        this.createTime = menuVO.createTime;
        this.children = menuVO.children;
    }
}
