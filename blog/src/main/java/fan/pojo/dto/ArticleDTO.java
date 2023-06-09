package fan.pojo.dto;

import fan.lang.Insert;
import fan.lang.Update;
import lombok.Data;

/**
 * 文章更新参数
 *
 * @author Fan
 * @since 2023/6/9 15:17
 */
@Data
public class ArticleDTO implements Insert, Update {

    private String id;

    private String categoryId;

    private String title;

    private String content;
}
