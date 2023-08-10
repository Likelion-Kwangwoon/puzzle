package com.puzzle.likelion.dto;

import com.puzzle.likelion.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ReviewDTO {
    private Long id;

    private Long articleId;

    private String content;

    private String writer;

    private Review.Rating rating;

    private Long views;

    /*public Review toEntity(){
        return new Review(id, articleId, content, writer, rating, views);
    }*/

}
