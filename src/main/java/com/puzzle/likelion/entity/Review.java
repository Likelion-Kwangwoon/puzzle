package com.puzzle.likelion.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name ="reviewTable")
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column
    //private Long articleId;

    @Column
    private String content;

    @Column
    private String writer;  //사용자 닉네임?

    @Column
    private Rating rating;

    @Column
    private Long views;

    //시간되면 작성날짜시간 추가..

    @ManyToOne
    private Member member;

    @ManyToOne
    private Article article;
    /*@Builder
    public Review(Long id, Long articleId, String content, String writer, Rating rating, Long views) {
        this.id = id;
        this.articleId = articleId;
        this.content = content;
        this.writer = writer;
        this.rating = rating;
        this.views = views;
    }*/

    public void patch(Review reviewEntity){
        if(reviewEntity.content != null ){
            this.content = reviewEntity.content;
        }
        if(reviewEntity.writer != null ){
            this.writer = reviewEntity.writer;
        }
        if(reviewEntity.rating != null ){
            this.rating = reviewEntity.rating;
        }

    }
    @Getter
    public enum Rating{
        ONE(1), TWO(2),  THREE(3), FOUR(4), FIVE(5);
        private int value;
        Rating(int value) {
            this.value = value;
        }
    }

}
