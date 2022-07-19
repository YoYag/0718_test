package com.testsite.sbb.reply.controller;

import com.testsite.sbb.article.domain.Article;
import com.testsite.sbb.article.service.ArticleService;
import com.testsite.sbb.reply.domain.Reply;
import com.testsite.sbb.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/reply")
@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final ArticleService articleService;
    private final ReplyService replyService;

    @PostMapping("/create/{id}")
    public String createReply(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Article article = this.articleService.getArticle(id);
        this.replyService.create(article, content);
        return String.format("redirect:/article/detail/%s", id);
    }

    @PostMapping("/like/{id}")
    public String likeReply(Model model, @PathVariable("id") Integer id) {
        this.replyService.like(id);
        return String.format("redirect:/article/detail/%s", id);
    }
}
