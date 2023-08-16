package com.puzzle.likelion.dto;

import com.puzzle.likelion.entity.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleResponse(Article article) { // Article 객체 받아서 ArticleResponse DTO 생성
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}
