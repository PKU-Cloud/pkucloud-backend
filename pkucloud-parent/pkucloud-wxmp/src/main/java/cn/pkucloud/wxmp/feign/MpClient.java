package cn.pkucloud.wxmp.feign;

import cn.pkucloud.wxmp.entity.wx.AccessToken;
import cn.pkucloud.wxmp.entity.wx.TemplateMessageResult;
import cn.pkucloud.wxmp.entity.wx.Ticket;
import cn.pkucloud.wxmp.entity.wx.UserInfoResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mp", url = "https://api.weixin.qq.com/cgi-bin/")
public interface MpClient {
    @GetMapping(value = "token", consumes = "application/json", produces = "application/json")
    AccessToken getAccessToken(@RequestParam String grant_type,
                               @RequestParam String appid,
                               @RequestParam String secret);

    @GetMapping("ticket/getticket?access_token={access_token}&type={type}")
    Ticket getTicket(@PathVariable String access_token,
                     @PathVariable String type);

    @PostMapping("message/custom/send?access_token={access_token}")
    String sendCustomMessage(@PathVariable String access_token);

    @PostMapping(value = "message/template/send?access_token={access_token}", consumes = "application/json")
    TemplateMessageResult sendTemplateMessage(@PathVariable String access_token);

    @GetMapping("user/info")
    UserInfoResult getUserInfo(@RequestParam String access_token,
                               @RequestParam String openid,
                               @RequestParam String lang);
}
