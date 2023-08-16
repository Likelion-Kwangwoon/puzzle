package com.puzzle.likelion.service;

import com.puzzle.likelion.dto.ReviewDTO;
import com.puzzle.likelion.entity.Review;
import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ReviewService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeArticleRepository repository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }
    public void create(ReviewDTO reviewDto) {
        Review review = reviewDto.toEntity();
        //Article targetArticle = articleRepository.findById(reviewDto.getId()).get();
        //review.setArticle(targetArticle);

        reviewRepository.save(review);
    }

    public Review edit(Long id, ReviewDTO reviewDto){
        Review reviewEntity = reviewDto.toEntity();
        Review target = reviewRepository.findById(id).orElse(null);

        if(target == null){
            return null;    //리뷰 id를 찾을 수 없어서 수정 불가인 경우
        }

        target.patch(reviewEntity);
        return reviewRepository.save(target);
    }

    public Review delete(Long id){
        Review target = reviewRepository.findById(id).orElse(null);

        if(target == null){
            return null;
        }

        reviewRepository.delete(target);
        return target;
    }

}
