package com.puzzle.likelion.dto;

import com.puzzle.likelion.entity.Comment;
import com.puzzle.likelion.entity.Review;
import com.puzzle.likelion.entity.Article;
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

    //private Long articleId;

    private String content;

    private String writer;

    private Long rating; //Review.Rating

    private Long views;

    //private Article articleId;

    /*public Review toEntity(){
        return new Review(id, content, writer, rating, views); //articleId,
    }*/
    public Review toEntity() {
        Review reviews = Review.builder()
                .id(id)
                .content(content)
                .writer(writer)
                .rating(rating)
                .views(views)
                .build();

        return reviews;
    }

}
