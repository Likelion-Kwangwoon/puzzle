package com.puzzle.likelion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteArticleRequest {
    private Long id;
    private String password;
}
