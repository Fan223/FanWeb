package fan.pojo.query;

import fan.query.BaseQuery;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 单词查询参数
 *
 * @author Fan
 * @since 2023/6/9 16:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class WordQuery extends BaseQuery {

    private String en;

    private String cn;

    private List<String> flag;
}
