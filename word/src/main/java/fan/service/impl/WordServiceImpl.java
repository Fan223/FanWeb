package fan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.core.util.CollectionUtil;
import fan.core.util.IdUtil;
import fan.dao.WordDAO;
import fan.lang.*;
import fan.pojo.dto.WordDTO;
import fan.pojo.entity.WordDO;
import fan.pojo.query.WordQuery;
import fan.service.WordService;
import fan.utils.WordMapStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 单词管理实现类
 *
 * @author Fan
 * @since 2023/6/9 16:27
 */
@Service
@Slf4j
public class WordServiceImpl implements WordService {

    @Resource
    private WordDAO wordDAO;

    @Override
    public Response page(Query query) {
        try {
            WordQuery wordQuery = (WordQuery) query;
            LambdaQueryWrapper<WordDO> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.eq(StringUtil.INSTANCE.isNotBlank(wordQuery.getEn()), WordDO::getEn, wordQuery.getEn())
                    .in(CollectionUtil.isNotEmpty(wordQuery.getFlag()), WordDO::getFlag, wordQuery.getFlag())
                    .like(StringUtil.INSTANCE.isNotBlank(wordQuery.getCn()), WordDO::getCn, wordQuery.getCn());

            Page<WordDO> page = wordDAO.selectPage(new Page<>(wordQuery.getCurrentPage(), wordQuery.getPageSize()), queryWrapper);
            return Response.success(WordMapStruct.INSTANCE.transWord(page));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询单词出现异常!");
        }
    }

    @Override
    public Response list(Query query) {
        try {
            WordQuery wordQuery = (WordQuery) query;
            LambdaQueryWrapper<WordDO> queryWrapper = new LambdaQueryWrapper<>();

            queryWrapper.like(WordDO::getEn, wordQuery.getEn())
                    .last("limit 5");
            return Response.success(WordMapStruct.INSTANCE.transWord(wordDAO.selectList(queryWrapper)));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("查询单词出现异常!");
        }
    }

    @Override
    public Response insert(Insert insert) {
        try {
            WordDO wordDO = WordMapStruct.INSTANCE.transWord((WordDTO) insert);

            wordDO.setId(String.valueOf(IdUtil.getSnowflakeId()));
            LocalDateTime localDateTime = LocalDateTime.now();
            wordDO.setCreateTime(Timestamp.valueOf(localDateTime));
            wordDO.setUpdateTime(Timestamp.valueOf(localDateTime));

            return Response.success(wordDAO.insert(wordDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("新增单词出现异常!");
        }
    }

    @Override
    public Response update(Update update) {
        try {
            WordDO wordDO = WordMapStruct.INSTANCE.transWord((WordDTO) update);
            wordDO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            return Response.success(wordDAO.updateById(wordDO));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("更新单词出现异常!");
        }
    }

    @Override
    public Response delete(List<String> ids) {
        try {
            return Response.success(wordDAO.deleteBatchIds(ids));
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return Response.fail("删除单词出现异常!");
        }
    }
}
