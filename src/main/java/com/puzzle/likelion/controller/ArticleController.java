package com.puzzle.likelion.controller;

import com.puzzle.likelion.dto.ArticleResponse;
import com.puzzle.likelion.dto.CreateArticleRequest;
import com.puzzle.likelion.dto.DeleteArticleRequest;
import com.puzzle.likelion.dto.UpdateArticleRequest;
import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody CreateArticleRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.createArticle(dto));
    }

    @GetMapping("")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = articleService.getAllArticles()
                .stream()// 스트림에 있는 각 Article 요소들을 ArticleResponse 객체로 매핑
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        ArticleResponse articleResponse =  new ArticleResponse(articleService.getArticleId(id));
        return ResponseEntity.ok()
                .body(articleResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id, @RequestBody String password) {
        DeleteArticleRequest deleteArticleRequest = new DeleteArticleRequest(id, password);
        boolean result = articleService.deleteArticle(deleteArticleRequest);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest dto) {
        boolean result = articleService.updateArticle(id, dto);
        if (result == true) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
