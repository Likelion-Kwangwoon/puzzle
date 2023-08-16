package com.puzzle.likelion.service;

import com.puzzle.likelion.dto.CreateArticleRequest;
import com.puzzle.likelion.dto.DeleteArticleRequest;
import com.puzzle.likelion.dto.UpdateArticleRequest;
import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.repository.ArticleRepository;
import com.puzzle.likelion.repository.CommentRepository;
import com.puzzle.likelion.repository.LikeArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeArticleRepository repository;

    // 모든 게시물 조회
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // 게시물 상세조회
    public Article getArticleId(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // 게시물 등록
    public Long createArticle(CreateArticleRequest dto) {
        Article article = Article.builder().nickname(dto.getNickname())
                .password(dto.getPassword())
                .title(dto.getTitle())
                .content(dto.getContent()).build();
        return articleRepository.save(article).getId();
    }

    // 게시물 삭제
    public boolean deleteArticle(DeleteArticleRequest dto) {
        Article article = articleRepository.findById(dto.getId()).orElse(null);
        if (article != null && dto.getPassword().equals(article.getPassword())) { // 비밀번호가 알맞으면 삭제
            articleRepository.deleteById(article.getId());
            return true;
        } else {
            return false;
        }

    }

    // 게시물 수정
    public boolean updateArticle(Long id, UpdateArticleRequest dto) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article != null && dto.getPassword().equals(article.getPassword())) { // 비밀번호가 알맞으면 수정
            article.setTitle(dto.getTitle());
            article.setContent(dto.getContent());
            articleRepository.save(article);
            return true;
        }
        return false;
    }

}
