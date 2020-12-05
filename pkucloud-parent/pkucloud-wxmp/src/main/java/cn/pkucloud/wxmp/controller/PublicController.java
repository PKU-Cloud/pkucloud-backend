package cn.pkucloud.wxmp.controller;

import cn.pkucloud.common.Result;
import cn.pkucloud.wxmp.entity.wx.Signature;
import cn.pkucloud.wxmp.service.PublicService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api", produces = "application/json")
@CrossOrigin
public class PublicController {
    private final PublicService publicService;

    public PublicController(PublicService publicService) {
        this.publicService = publicService;
    }

    @GetMapping("signature")
    public Result<Signature> getSignature(@RequestParam String url) {
        return publicService.getSignature(url);
    }
}
