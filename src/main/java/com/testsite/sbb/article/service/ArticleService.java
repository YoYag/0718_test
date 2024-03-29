package com.testsite.sbb.article.service;

import com.testsite.sbb.DataNotFoundException;
import com.testsite.sbb.article.dao.ArticleRepository;
import com.testsite.sbb.article.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> oparticle = this.articleRepository.findById(id);
        if (oparticle.isPresent()) {
            Article article = oparticle.get();
            article.setHits(article.getHits() + 1);
            articleRepository.save(article);
            return article;
        } else {
            throw new DataNotFoundException("article not found");
        }
    }
}
