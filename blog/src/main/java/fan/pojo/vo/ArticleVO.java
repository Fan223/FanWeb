package fan.pojo.vo;

import lombok.Data;

/**
 * 文章展示类
 *
 * @author Fan
 * @since 2023/6/9 15:17
 */
@Data
public class ArticleVO {

    private String id;

    private String categoryId;

    private String title;

    private String content;

    private String flag;

    private String createTime;
}
