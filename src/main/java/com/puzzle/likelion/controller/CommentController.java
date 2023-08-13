package com.puzzle.likelion.controller;


import com.puzzle.likelion.dto.CommentRequestDto;
import com.puzzle.likelion.entity.Comment;
import com.puzzle.likelion.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("comment")
    public String createComment(@RequestBody CommentRequestDto request) {
        System.out.println(request);

        commentService.commentCreate(request);
        return "작성 완료";
    }
    //아이디 번호로 불러오는 것

    //같은 게시글의 댓글 불러오기
}
