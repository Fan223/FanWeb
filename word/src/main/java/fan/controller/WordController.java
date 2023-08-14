package fan.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.WordDTO;
import fan.pojo.query.WordQuery;
import fan.pojo.vo.WordVO;
import fan.service.WordService;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * 单词管理 Controller
 *
 * @author Fan
 * @since 2023/6/9 16:26
 */
@RestController
@RequestMapping("/word")
public class WordController {

    @Resource
    private WordService wordService;

    @GetMapping("/pageWords")
    public Response<Page<WordVO>> pageWords(WordQuery wordQuery) {
        return wordService.pageWords(wordQuery);
    }

    @GetMapping("/listWords/{en}")
    public Response<List<WordVO>> listWords(@PathVariable("en") String en) {
        return wordService.listWords(WordQuery.builder().en(en).build());
    }

    @PostMapping("/addWord")
    public Response<Integer> addWord(@RequestBody WordDTO wordDTO) {
        return wordService.addWord(wordDTO);
    }

    @PutMapping("/updateWord")
    public Response<Integer> updateWord(@RequestBody WordDTO wordDTO) {
        return wordService.updateWord(wordDTO);
    }

    @DeleteMapping("/deleteWord/{id}")
    public Response<Integer> deleteWord(@PathVariable("id") List<String> ids) {
        return wordService.deleteWord(ids);
    }
}
