package com.testsite.sbb.reply.service;

import com.testsite.sbb.article.domain.Article;
import com.testsite.sbb.reply.dao.ReplyRepository;
import com.testsite.sbb.reply.domain.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;


    public void create(Article article, String content) {
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setCreateDate(LocalDateTime.now());
        reply.setArticle(article);
        this.replyRepository.save(reply);
    }

    public void like(int id) {
        Reply reply = replyRepository.findById(id).get();
        reply.setLikeIt(!reply.getLikeIt());
        this.replyRepository.save(reply);
    }
}