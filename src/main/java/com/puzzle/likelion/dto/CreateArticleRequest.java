package com.puzzle.likelion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateArticleRequest {
    private String nickname;
    private String password;
    private String title;
    private String content;

}
