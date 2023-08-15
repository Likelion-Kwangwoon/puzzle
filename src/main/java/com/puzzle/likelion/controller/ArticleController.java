package com.puzzle.likelion.controller;

import com.puzzle.likelion.dto.CommentRequestDto;
import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {
    //커밋테스트

    @Autowired
    private ArticleService articleService;

//localhost:8080/article Post
    @PostMapping("")
    public String createArticle(@RequestBody Article article) {
        System.out.println(article);

        articleService.articleCreate(article);
        return "작성 성공";
    }
    @GetMapping("/view")
    public List<Article> viewArticle() {
        List<Article> response = articleService.getAllArticles();
        return response;
    }
}
