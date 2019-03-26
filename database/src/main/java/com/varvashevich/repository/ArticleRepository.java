package com.varvashevich.repository;

import com.varvashevich.entity.Article;
import com.varvashevich.entity.enumonly.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    Optional<Article> findByTitleIgnoreCase(String name, Pageable pageable);

    @Override
    List<Article> findAll();

    List<Article> findAllByStatus(Status status, Pageable pageable);

    @Query("select ar from Article ar join ar.tags t where t.name in :tags")
    List<Article> findArticlesByTags(@Param("tags") Collection<String> tags, Pageable pageable);
}
