package com.puzzle.likelion.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Text", nullable = false)
    private String comment;

    @Column(name = "created_date")
    @CreatedDate
    private String createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private String modifiedDate;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Article article;

    private String content;

    public void update(String comment) {
        this.comment = comment;
    }
    //대댓글 정책은 어떻게 할건지?

}
