package com.puzzle.likelion.service;

import com.puzzle.likelion.dto.CommentRequestDto;
import com.puzzle.likelion.dto.CommentResponseDto;
import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.entity.Comment;
import com.puzzle.likelion.entity.Member;
import com.puzzle.likelion.entity.User;
import com.puzzle.likelion.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LikeArticleRepository repository;
    @Autowired
    private MemberRepository memberRepository;

    public CommentService() {
    }


    public Comment commentService(Comment comment) {

        //유저 불러오는 부분 , 추후 삭제
        // memberRepository.findById(); 느낌으로 대체
        Member member = Member.builder().build();
        //게시글 불러오는 부분 , 추후 삭제
        Article article = Article.builder().build();

        Comment makeComment = Comment.builder()
                .member(member)
                .article(article)
                .content(comment.getContent())
                .build();

        /*public Comment addComment(String comment) {
            //Comment comment = new Comment();
        }

        public List<Comment> getAllComments() {
        }*/



        commentRepository.save(comment);
        return comment;
    }

    public void commentCreate(CommentRequestDto request) {
        Comment comment = request.toEntity();
        Article article = articleRepository.findById(request.getId()).get();

        commentRepository.save(comment);
    }

    public List<Comment> viewAllSameName(String comment) {
        return commentRepository.findAllByComment(comment);
    }

    public List<Comment> viewAllSameId(String comment) {
        return commentRepository.findAllByComment(comment);
    }
}
