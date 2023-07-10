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

    /**
     * 分页获取标签
     *
     * @param tagQuery 标签查询参数
     * @return {@link Response<Page<TagVO>>}
     * @author Fan
     * @since 2023/7/10 14:13
     */
    Response<Page<TagVO>> pageTags(TagQuery tagQuery);

    /**
     * 添加标签
     *
     * @param tagDTO 标签更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:14
     */
    Response<Integer> addTag(TagDTO tagDTO);

    /**
     * 修改标签
     *
     * @param tagDTO 标签更新参数
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:15
     */
    Response<Integer> updateTag(TagDTO tagDTO);

    /**
     * 删除标签
     *
     * @param ids ID列表
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/7/10 14:15
     */
    Response<Integer> deleteTag(List<String> ids);
}
