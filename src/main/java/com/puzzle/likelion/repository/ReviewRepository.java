package com.puzzle.likelion.repository;

import com.puzzle.likelion.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findAllByContent(String content);
}
