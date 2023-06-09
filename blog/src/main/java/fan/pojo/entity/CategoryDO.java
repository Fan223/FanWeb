package fan.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 分类实体类
 *
 * @author Fan
 * @since 2023/6/9 16:04
 */
@Data
@TableName("category")
public class CategoryDO {

    @TableId
    private String id;

    private String name;

    private String remark;

    private Integer orderNum;

    private String flag;

    private Timestamp createTime;

    private Timestamp updateTime;
}
