package fan.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 文章实体类
 *
 * @author Fan
 * @since 2023/6/9 15:15
 */
@Data
@TableName("article")
public class ArticleDO {

    @TableId
    private String id;

    private String categoryId;

    private String title;

    private String content;

    private String flag;

    private Timestamp createTime;

    private Timestamp updateTime;
}
