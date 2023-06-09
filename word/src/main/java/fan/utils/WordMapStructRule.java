package fan.utils;

import fan.core.consts.StrPool;
import fan.core.util.MapUtil;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 单词转换规则
 *
 * @author Fan
 * @since 2023/6/9 16:44
 */
public class WordMapStructRule {

    private WordMapStructRule() {
    }

    protected static final Map<String, String> WORD_TYPE = MapUtil.builder("日常单词", "0").put("专业名词", "1").put("短语", "2")
            .put("0", "日常单词").put("1", "专业名词").put("2", "短语").build();

    @Named("transType")
    public static List<String> transType(String str) {
        List<String> list = Arrays.asList(str.split(StrPool.COMMA.value()));
        return list.stream().map(WORD_TYPE::get).collect(Collectors.toList());
    }

    @Named("transTypes")
    public static String transTypes(List<String> list) {
        return list.stream().map(WORD_TYPE::get).collect(Collectors.joining(StrPool.COMMA.value()));
    }
}
