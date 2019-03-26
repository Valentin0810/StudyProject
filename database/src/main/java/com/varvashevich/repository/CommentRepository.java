package com.varvashevich.repository;

import com.varvashevich.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAllByArticleId(Long articleId);

    List<Comment> findAllByUserId(Long userId);

    List<Comment> findAllByUserEmail(String email);
}