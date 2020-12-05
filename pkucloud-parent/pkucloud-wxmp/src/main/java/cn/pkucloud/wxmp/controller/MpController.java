package cn.pkucloud.wxmp.controller;

import cn.pkucloud.wxmp.entity.wx.XmlRequest;
import cn.pkucloud.wxmp.entity.wx.XmlResponse;
import cn.pkucloud.wxmp.exception.AesException;
import cn.pkucloud.wxmp.service.MpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("mp")
@Validated
public class MpController {
    private final MpService mpService;

    public MpController(MpService mpService) {
        this.mpService = mpService;
    }

    @GetMapping
    public String echo(@NotBlank(message = "signature required") String signature,
                       @NotBlank(message = "echostr required") String echostr,
                       @NotBlank(message = "timestamp required") int timestamp,
                       @NotBlank(message = "nonce required") String nonce) {
        System.out.println("signature = " + signature);
        System.out.println("echostr = " + echostr);
        System.out.println("timestamp = " + timestamp);
        System.out.println("nonce = " + nonce);
        return mpService.echo(signature, echostr, timestamp, nonce);
    }

    @PostMapping(consumes = "text/xml", produces = "text/xml")
    public XmlResponse msgHandler(@RequestParam String signature,
                                  @RequestParam int timestamp,
                                  @RequestParam String nonce,
                                  @RequestParam String openid,
                                  @RequestParam String encrypt_type,
                                  @RequestParam String msg_signature,
                                  @RequestBody XmlRequest request) throws AesException, JsonProcessingException {
        System.out.println("signature = " + signature);
        System.out.println("timestamp = " + timestamp);
        System.out.println("nonce = " + nonce);
        System.out.println("openid = " + openid);
        System.out.println("encrypt_type = " + encrypt_type);
        System.out.println("msg_signature = " + msg_signature);
        System.out.println("request = " + request);
        return mpService.msgHandler(signature, timestamp, nonce, openid, encrypt_type, msg_signature, request);
    }
}
