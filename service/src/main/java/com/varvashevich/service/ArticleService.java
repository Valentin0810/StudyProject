package com.varvashevich.service;

import com.varvashevich.entity.Article;
import com.varvashevich.repository.ArticleRepository;
import com.varvashevich.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final TagRepository tagRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }


}