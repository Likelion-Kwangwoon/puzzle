package com.puzzle.likelion.repository;

import com.puzzle.likelion.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
