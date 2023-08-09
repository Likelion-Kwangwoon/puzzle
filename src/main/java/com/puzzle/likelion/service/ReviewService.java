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
    private MemberRepository memberRepository;
    @Autowired
    private static ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public static List<Review> findAll() {
        return reviewRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }
    //public Review create(ReviewDTO reviewDto) { }

    //public Review edit(Long id, ReviewDTO reviewDto) { }

    //public Review delete(Long id) { }
}
