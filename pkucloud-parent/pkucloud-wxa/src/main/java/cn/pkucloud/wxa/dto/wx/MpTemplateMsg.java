package cn.pkucloud.wxa.dto.wx;

import lombok.Data;

@Data
public class MpTemplateMsg {
    private String appid;
    private String template_id;
    private String url;
    private String miniprogram;
    private String data;
}
