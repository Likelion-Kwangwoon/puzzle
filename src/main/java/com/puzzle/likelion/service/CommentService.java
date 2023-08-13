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

        /*@Transactional
        public Long commentSave(String nickname, Long id, CommentRequestDto dto) {
            User user = UserRepository.findByNickname(nickname);
            Article article = articleRepository.findById(id).orElseThrow(() ->
                    new IllegalArgumentException("댓글 쓰기 실패 : 해당 게시글이 존재하지 않습니다." + id));

            dto.setUser(user);
            dto.setArticle(article);

            Comment comment = dto.toEntity();
            commentRepository.save(comment);

            return dto.getId();
        }*/

        /*@Transactional
        public void update(Long postsId, Long id, CommentRequestDto.Request dto) {
            Comment comment = commentRepository.findByPostsIdAndId(postsId, id).orElseThrow(() ->
                    new IllegalAccessException("해당 댓글이 존재하지 않습니다." + id));

            comment.update(dto.getComment());
        }*/

        /*@Transactional
        public void delete(Long postsId, Long id) {
            Comment comment = commentRepository.findByPostsIdAndId(postsId, id).orElseThrow(() ->
                    new IllegalAccessException("해당 댓글이 존재하지 않습니다. id=" + id));

            commentRepository.delete(comment);
        }*/


        commentRepository.save(comment);
        return comment;
    }
}
