package com.puzzle.likelion.controller;

import com.puzzle.likelion.dto.ReviewDTO;
import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.entity.Review;
import com.puzzle.likelion.service.ArticleService;
import com.puzzle.likelion.service.ReviewService;
import com.puzzle.likelion.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("review")
public class ReviewController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeArticleRepository repository;
    //@Autowired
    //private MemberRepository memberRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewService reviewService;
    @GetMapping("")      // 리뷰 리스트 보여주기
    public String allReviewPage(Model model){
        List<Review> reviewList = reviewService.findAll();
        model.addAttribute("reviewList", reviewList);
        return "/review/reviews";
    }

    @GetMapping("/{id}") //상세 리뷰 페이지
    public String detailReviewPage(@PathVariable Long id, Model model) {
        Review review = reviewService.findById(id);
        model.addAttribute("reviewEntity", review);
        return "/review/detail";
    }

    @PostMapping("/createReview")
    public String createReview(@RequestBody ReviewDTO request) {
        System.out.println(request);
        reviewService.create(request);
        return "새로운 리뷰 작성 성공";
    }

    @PostMapping("/editReview")
    public String updateReview(@RequestParam Long id, @RequestBody ReviewDTO reviewDto){
        System.out.println(reviewDto);
        if (reviewService.edit(id, reviewDto) != null)
            return "ID : " + reviewDto.getId() + " 리뷰 수정 완료";
        else
            return "리뷰 수정 실패";  //해당하는 id를 찾지 못한 경우

    }
    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable Long id){
        if (reviewService.delete(id) != null)
            return "ID : " + id + " 리뷰 삭제 완료";
        else
            return "리뷰 삭제 실패";
    }
}
