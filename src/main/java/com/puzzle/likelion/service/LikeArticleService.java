package com.puzzle.likelion.service;

import com.puzzle.likelion.repository.ArticleRepository;
import com.puzzle.likelion.repository.CommentRepository;
import com.puzzle.likelion.repository.LikeArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeArticleRepository repository;


}
