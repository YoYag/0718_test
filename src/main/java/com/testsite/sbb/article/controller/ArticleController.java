package com.testsite.sbb.article.controller;

import com.testsite.sbb.article.dao.ArticleRepository;
import com.testsite.sbb.article.domain.Article;
import com.testsite.sbb.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    // 전체조회
    @RequestMapping("/list")
    public String showArticles(Model model) {
        List<Article> articleList = this.articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        article.setHits(article.getHits() + 1);
        articleRepository.save(article);
        return "article_detail";
    }
}
