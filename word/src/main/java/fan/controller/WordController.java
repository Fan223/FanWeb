package fan.controller;

import fan.lang.Response;
import fan.pojo.dto.WordDTO;
import fan.pojo.query.WordQuery;
import fan.service.WordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public Response pageWords(WordQuery wordQuery) {
        return wordService.page(wordQuery);
    }

    @GetMapping("/listWords/{en}")
    public Response listWords(@PathVariable("en") String en) {
        return wordService.list(WordQuery.builder().en(en).build());
    }

    @PostMapping("/addWord")
    public Response addWord(@RequestBody WordDTO wordDTO) {
        return wordService.insert(wordDTO);
    }

    @PutMapping("/updateWord")
    public Response updateWord(@RequestBody WordDTO wordDTO) {
        return wordService.update(wordDTO);
    }

    @DeleteMapping("/deleteWord/{id}")
    public Response deleteWord(@PathVariable("id") List<String> ids) {
        return wordService.delete(ids);
    }
}
