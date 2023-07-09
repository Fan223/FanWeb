package fan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fan.lang.Response;
import fan.pojo.dto.TagDTO;
import fan.pojo.query.TagQuery;
import fan.pojo.vo.TagVO;

import java.util.List;

/**
 * 标签管理接口
 *
 * @author Fan
 * @since 2023/6/21 13:52
 */
public interface TagService {

    Response<Page<TagVO>> pageTags(TagQuery tagQuery);

    Response<Integer> addTag(TagDTO tagDTO);

    Response<Integer> updateTag(TagDTO tagDTO);

    Response<Integer> deleteTag(List<String> ids);
}
