package com.puzzle.likelion.controller;


import com.puzzle.likelion.dto.CommentRequestDto;
import com.puzzle.likelion.entity.Comment;
import com.puzzle.likelion.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("comment")
    public String createComment(@RequestBody CommentRequestDto request) {
        System.out.println(request);

        commentService.commentCreate(request);
        return "작성 성공";
    }

    //아이디 번호로 불러오는 것
    @GetMapping("/sameId")
    public List<Comment> viewAllSameId(@RequestParam String comment) {
        List<Comment> response = commentService.viewAllSameId(comment);
        return response;
    }

    //같은 게시글의 댓글 불러오기
    @GetMapping("/sameArticle")
    public List<Comment> viewAllSameName(@RequestParam String comment) {
        List<Comment> response = commentService.viewAllSameName(comment);
        return response;
    }

    // DELETE
    @DeleteMapping("/delete")
    public Long deleteComment(@PathVariable final Long postId, @PathVariable final Long id) {
        return commentService.deleteComment(id);
    }
}