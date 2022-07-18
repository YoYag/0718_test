package com.testsite.sbb.article.controller;

import com.testsite.sbb.article.dao.ArticleRepository;
import com.testsite.sbb.article.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleRepository articleRepository;

    // 전체조회
    @RequestMapping("/list")
    public String showArticles(Model model) {
        List<Article> articleList = this.articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

}
