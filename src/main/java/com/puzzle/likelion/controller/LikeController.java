package com.puzzle.likelion.controller;

import com.puzzle.likelion.service.LikeArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("like")
public class LikeController {

    @Autowired
    private LikeArticleService likeArticleService;
}
