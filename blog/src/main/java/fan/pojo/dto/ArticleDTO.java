package fan.pojo.dto;

import lombok.Data;

/**
 * 文章更新参数
 *
 * @author Fan
 * @since 2023/6/9 15:17
 */
@Data
public class ArticleDTO {

    private String id;

    private String categoryId;

    private String title;

    private String content;
}
