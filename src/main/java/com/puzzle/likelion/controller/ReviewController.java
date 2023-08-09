package com.puzzle.likelion.controller;

import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.entity.Review;
import com.puzzle.likelion.service.ArticleService;
import com.puzzle.likelion.service.ReviewService;
import com.puzzle.likelion.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
public class ReviewController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeArticleRepository repository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/review")      // 리뷰 리스트 보여주기
    public String allReviewPage(Model model){
        //List<Review> reviewList = reviewRepository.findAll();
        List<Review> reviewList = ReviewService.findAll();
        model.addAttribute("reviewList", reviewList);
        return "/review/reviews";
    }
    //리뷰 작성 창
    //새 리뷰 작성 후 DB 저장
    //리뷰 수정 페이지
    //리뷰 수정
    //리뷰 삭제
}
