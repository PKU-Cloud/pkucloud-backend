package cn.pkucloud.wxmp.entity.wx;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoResult extends BaseResult {
    private int subscribe;
    private String openid;
    private String nickname;
    private int sex;
    private String city;
    private String country;
    private String province;
    private String language;
    private String headimgurl;
    private int subscribe_time;
    private String unionid;
    private String remark;
}
