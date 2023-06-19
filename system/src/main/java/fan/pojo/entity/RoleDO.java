package fan.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 角色实体类
 *
 * @author Fan
 * @since 2023/6/19 10:40
 */
@Data
@TableName("role")
public class RoleDO {

    @TableId
    private String id;

    private String code;

    private String name;

    private String remark;

    private String flag;

    private Timestamp createTime;

    private Timestamp updateTime;
}
