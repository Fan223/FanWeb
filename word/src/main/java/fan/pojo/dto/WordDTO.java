package fan.pojo.dto;

import fan.lang.Insert;
import fan.lang.Update;
import lombok.Data;

import java.util.List;

/**
 * 单词更新参数
 *
 * @author Fan
 * @since 2023/6/9 16:30
 */
@Data
public class WordDTO implements Insert, Update {

    private String id;

    private String en;

    private String pronunciation;

    private String cn;

    private List<String> type;

    private String flag;
}
