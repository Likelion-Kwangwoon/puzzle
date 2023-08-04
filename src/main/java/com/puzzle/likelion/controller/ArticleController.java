package com.puzzle.likelion.controller;

import com.puzzle.likelion.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
public class ArticleController {
    //커밋테스트

    @Autowired
    private ArticleService articleService;

}
