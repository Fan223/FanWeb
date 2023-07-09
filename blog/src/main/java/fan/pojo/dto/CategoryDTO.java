package fan.pojo.dto;

import lombok.Data;

/**
 * 分类更新参数
 *
 * @author Fan
 * @since 2023/6/9 16:06
 */
@Data
public class CategoryDTO {

    private String id;

    private String name;

    private String remark;

    private String flag;

    private Integer orderNum;
}
