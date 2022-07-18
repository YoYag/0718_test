package com.testsite.sbb.reply.controller;

import com.testsite.sbb.reply.dao.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyRepository replyRepository;

    // 단건조회
//    @RequestMapping("/detail")
//    @ResponseBody
//    public Reply showReply(@RequestParam long id) {
//        Optional<Reply> opr = replyRepository.findById((int)id);
//        return opr.orElse(null);
//    }
}
