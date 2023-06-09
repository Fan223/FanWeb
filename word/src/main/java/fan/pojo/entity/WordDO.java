package fan.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 单词实体类
 *
 * @author Fan
 * @since 2023/6/9 16:28
 */
@Data
@TableName("word")
public class WordDO {

    @TableId
    private String id;

    private String en;

    private String pronunciation;

    private String cn;

    private String type;

    private String flag;

    private Timestamp createTime;

    private Timestamp updateTime;
}
