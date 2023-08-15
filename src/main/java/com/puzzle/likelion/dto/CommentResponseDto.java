package com.puzzle.likelion.dto;

import com.puzzle.likelion.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponseDto {
    private long id;
    private String comment;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    //private String nickname;
    //private Long articleID;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.createdDate = comment.getCreatedDate();
        //this.nickname = comment.getMember().getNickname();
        //this.articleID = comment.getArticle().getId();
    }
}
