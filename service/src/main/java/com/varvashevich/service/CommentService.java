package com.varvashevich.service;

import com.varvashevich.entity.Article;
import com.varvashevich.entity.Comment;
import com.varvashevich.entity.User;
import com.varvashevich.exception.DataBaseException;
import com.varvashevich.repository.ArticleRepository;
import com.varvashevich.repository.CommentRepository;
import com.varvashevich.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public List<Comment> findArticleComments(Long articleId) {
        return commentRepository.findAllByArticleId(articleId);
    }

    public List<Comment> findUserComments(Long userId) {
        return commentRepository.findAllByUserId(userId);
    }

    public List<Comment> findUserComments(String email) {
        return commentRepository.findAllByUserEmail(email);
    }

    @Transactional
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Transactional
    public Comment save(Comment newComment) {
        Article article = articleRepository.findById(newComment.getArticle().getId()).orElseThrow(DataBaseException::new);
        User user = userRepository.findById(newComment.getUser().getId()).orElseThrow(DataBaseException::new);
        return commentRepository.save(Comment.builder()
                .message(newComment.getMessage())
                .article(article)
                .user(user)
                .createdAt(LocalDateTime.now())
                .build());
    }
}