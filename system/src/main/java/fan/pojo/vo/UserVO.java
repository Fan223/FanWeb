package fan.pojo.vo;

import lombok.Data;

/**
 * 用户展示类
 *
 * @author Fan
 * @since 2023/6/9 14:29
 */
@Data
public class UserVO {

    private String id;

    private String username;

    private String avatar;

    private String flag;

    private String createTime;
}
