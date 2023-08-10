package fan.service;

import fan.lang.Response;

import java.util.Map;

/**
 * 博客管理接口
 *
 * @author Fan
 * @since 2023/8/10 8:55
 */
public interface BlogService {

    /**
     * 清除失效的图片
     *
     * @return {@link Response <Integer>}
     * @author Fan
     * @since 2023/8/10 8:50
     */
    Response<Integer> cleanInvalidImage();

    /**
     * 导出文件
     *
     * @return {@link Response<Integer>}
     * @author Fan
     * @since 2023/8/10 8:50
     */
    Response<Map<String, Integer>> exportArticle();
}
