package fan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.WordDTO;
import fan.pojo.query.WordQuery;
import fan.pojo.vo.WordVO;

import java.util.List;

/**
 * 单词管理接口
 *
 * @author Fan
 * @since 2023/6/9 16:26
 */
public interface WordService {

    /**
     * 分页获取单词
     *
     * @param wordQuery 单词查询参数
     * @return {@link Response<Page<WordVO>>}
     * @author Fan
     * @since 2023/7/10 14:25
     */
    Response<Page<WordVO>> pageWords(WordQuery wordQuery);

    /**
     * 获取单词列表
     *
     * @param wordQuery 单词查询参数
     * @return {@link Response<List<WordVO>>}
     * @author Fan
     * @since 2023/7/10 14:26
     */
    Response<List<WordVO>> listWords(WordQuery wordQuery);

    /**
     * 添加单词
     *
     * @param wordDTO 单词更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:26
     */
    Response<Integer> addWord(WordDTO wordDTO);

    /**
     * 修改单词
     *
     * @param wordDTO 单词更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:26
     */
    Response<Integer> updateWord(WordDTO wordDTO);

    /**
     * 删除单词
     *
     * @param ids ID列表
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:26
     */
    Response<Integer> deleteWord(List<String> ids);
}
