package fan.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 用户实体类
 *
 * @author Fan
 * @since 2023/6/9 14:26
 */
@Data
@TableName("user")
public class UserDO {

    @TableId
    private String id;

    private String username;

    private String password;

    private String avatar;

    private String flag;

    private Timestamp createTime;

    private Timestamp updateTime;
}
