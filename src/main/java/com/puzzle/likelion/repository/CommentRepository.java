package com.puzzle.likelion.repository;

import com.puzzle.likelion.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
