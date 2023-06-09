package fan.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * 单词展示类
 *
 * @author Fan
 * @since 2023/6/9 16:29
 */
@Data
public class WordVO {

    private String id;

    private String en;

    private String pronunciation;

    private String cn;

    private List<String> type;

    private String flag;
}
