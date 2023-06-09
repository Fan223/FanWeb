package fan.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.pojo.dto.WordDTO;
import fan.pojo.entity.WordDO;
import fan.pojo.vo.WordVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 单词转换类
 *
 * @author Fan
 * @since 2023/6/9 16:33
 */
@Mapper(uses = WordMapStructRule.class)
public interface WordMapStruct {

    WordMapStruct INSTANCE = Mappers.getMapper(WordMapStruct.class);

    /**
     * 单词实体类转展示类
     *
     * @param wordDO 单词实体类
     * @return {@link WordVO}
     * @author Fan
     * @since 2023/6/9 16:35
     */
    @Mapping(target = "type", source = "type", qualifiedByName = "transType")
    WordVO transWord(WordDO wordDO);

    /**
     * 单词实体类列表转展示类列表
     *
     * @param wordDos 单词实体类列表
     * @return {@link List<WordVO>}
     * @author Fan
     * @since 2023/6/9 16:35
     */
    List<WordVO> transWord(List<WordDO> wordDos);

    /**
     * 单词实体类分页转展示类分页
     *
     * @param wordPage 单词实体类分页
     * @return {@link Page<WordVO>}
     * @author Fan
     * @since 2023/6/9 16:36
     */
    Page<WordVO> transWord(Page<WordDO> wordPage);

    /**
     * 单词更新参数转实体类
     *
     * @param wordDTO 单词更新参数
     * @return {@link WordDO}
     * @author Fan
     * @since 2023/6/9 16:36
     */
    @Mapping(target = "type", source = "type", qualifiedByName = "transTypes")
    WordDO transWord(WordDTO wordDTO);
}
