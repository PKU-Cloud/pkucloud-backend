package cn.pkucloud.qa.controller;

import cn.pkucloud.common.PageResult;
import cn.pkucloud.common.Result;
import cn.pkucloud.qa.entity.Answer;
import cn.pkucloud.qa.entity.Comment;
import cn.pkucloud.qa.service.QaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("qa/answer")
public class AnswerController {
    private final QaService qaService;

    public AnswerController(QaService qaService) {
        this.qaService = qaService;
    }

    @GetMapping("{id}")
    public Result<Answer> getAnswerById(@RequestHeader("iss") String issuer,
                                        @RequestHeader("uid") String uid,
                                        @RequestHeader("role") String role,
                                        @RequestHeader("mod") String mod,
                                        @PathVariable String id) {
        return qaService.getAnswerById(issuer, uid, role, mod, id);
    }

    @GetMapping("{aid}/comment")
    public PageResult<Comment> getCommentByAid(@RequestHeader("iss") String issuer,
                                               @RequestHeader("uid") String uid,
                                               @RequestHeader("role") String role,
                                               @RequestHeader("mod") String mod,
                                               @PathVariable String aid,
                                               @RequestParam int size,
                                               @RequestParam int page) {
        return qaService.getCommentByAid(issuer, uid, role, mod, aid, size, page);
    }

    @PostMapping("{aid}/comment")
    public Result<?> postComment(@RequestHeader("iss") String issuer,
                                 @RequestHeader("uid") String uid,
                                 @RequestHeader("role") String role,
                                 @RequestHeader("mod") String mod,
                                 @PathVariable String aid,
                                 @RequestParam String pid,
                                 @RequestParam String txt,
                                 @RequestParam(required = false) String[] img,
                                 @RequestParam int setting) {
        return qaService.postComment(issuer, uid, role, mod, aid, pid, txt, img, setting);
    }

    @PostMapping("{aid}/report")
    public Result<?> postReport(@RequestHeader("iss") String issuer,
                                @RequestHeader("uid") String uid,
                                @RequestHeader("role") String role,
                                @RequestHeader("mod") String mod,
                                @PathVariable String aid,
                                @RequestParam String txt) {
        return qaService.postReport(issuer, uid, role, mod, "answer", aid, txt);
    }

    @PutMapping("{id}")
    public Result<?> putLike(@RequestHeader("iss") String issuer,
                             @RequestHeader("uid") String uid,
                             @RequestHeader("role") String role,
                             @RequestHeader("mod") String mod,
                             @PathVariable String id,
                             @RequestParam int like) {
        return qaService.putAnswerLike(issuer, uid, role, mod, id, like);
    }
}
