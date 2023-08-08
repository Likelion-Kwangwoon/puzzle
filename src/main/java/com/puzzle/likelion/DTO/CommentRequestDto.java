package com.puzzle.likelion.DTO;

import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.entity.Comment;
import com.puzzle.likelion.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CommentRequestDto {
    private Long id;
    private String comment;
    private String CreatedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private Member member;
    private Article article;

    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .comment(comment)
                .createdDate(CreatedDate)
                .modifiedDate(modifiedDate)
                .member(member)
                .article(article)
                .build();
        return comments;
    }
}
