package fan.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 标签实体类
 *
 * @author Fan
 * @since 2023/6/21 13:53
 */
@Data
@TableName("tag")
public class TagDO {

    @TableId
    private String id;

    private String name;

    private String flag;

    private Timestamp createTime;

    private Timestamp updateTime;
}
