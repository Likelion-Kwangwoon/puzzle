package com.puzzle.likelion.controller;


import com.puzzle.likelion.entity.Comment;
import com.puzzle.likelion.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    //예시코드
    @PostMapping("comment")
    public Comment createComment(Comment comment) {

        return commentService.commentService(comment);
    }
}
