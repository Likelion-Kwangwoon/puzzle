package com.puzzle.likelion.service;

import com.puzzle.likelion.DTO.CommentRequestDto;
import com.puzzle.likelion.entity.Article;
import com.puzzle.likelion.entity.Comment;
import com.puzzle.likelion.entity.Member;
import com.puzzle.likelion.repository.ArticleRepository;
import com.puzzle.likelion.repository.CommentRepository;
import com.puzzle.likelion.repository.LikeArticleRepository;
import com.puzzle.likelion.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
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


    public Comment commentService(Comment comment) {

        //유저 불러오는 부분 , 추후 삭제
        // memberRepository.findById(); 느낌으로 대체
        Member member = Member.builder().build();
        //게시글 불러오는 부분 , 추후 삭제
        Article article = Article.builder().build();

    }

    @Transactional
    public Long commentSave(String nickname, Long id, CommentRequestDto dto) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글 쓰기 실패 : 해당 게시글이 존재하지 않습니다." + id));

        dto.setMember();
        dto.setArticle();

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }
}