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

    Response<Page<WordVO>> pageWords(WordQuery wordQuery);

    Response<List<WordVO>> listWords(WordQuery wordQuery);

    Response<Integer> addWord(WordDTO wordDTO);

    Response<Integer> updateWord(WordDTO wordDTO);

    Response<Integer> deleteWord(List<String> ids);
}
