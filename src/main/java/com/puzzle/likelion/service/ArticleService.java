package com.puzzle.likelion.service;

import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.repository.ArticleRepository;
import com.puzzle.likelion.repository.CommentRepository;
import com.puzzle.likelion.repository.LikeArticleRepository;
import com.puzzle.likelion.repository.MemberRepository;
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
    @Autowired
    private MemberRepository memberRepository;


    public void articleCreate(Article article) {
        articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
