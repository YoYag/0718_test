package com.testsite.sbb.article.controller;

import com.testsite.sbb.article.dao.ArticleRepository;
import com.testsite.sbb.article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    // 전체조회
    @RequestMapping("/list")
    @ResponseBody
    public List<Article> showArticles() {
        return articleRepository.findAll();
    }
}
