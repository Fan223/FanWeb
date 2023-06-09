package fan.pojo.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单展示类
 *
 * @author Fan
 * @since 2023/6/9 11:17
 */
@Data
public class MenuVO {

    private String id;

    private String parentId;

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
}
