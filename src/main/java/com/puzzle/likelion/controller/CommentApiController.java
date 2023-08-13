package com.puzzle.likelion.controller;

import com.puzzle.likelion.dto.CommentRequestDto;
import com.puzzle.likelion.dto.CommentResponseDto;
import com.puzzle.likelion.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CommentApiController {

    private final CommentService commentService;

    /* CREATE */
    /*@PostMapping("/posts/{id}/comments")
    public ResponseEntity commentSave(
            @PathVariable Long id,
            @RequestBody CommentRequestDto dto,
            @) {
        return ResponseEntity.ok();
    }*/

    /* UPDATE */
    /*@PutMapping({"/posts/{postsId}/comments/{id}"})
    public ResponseEntity<Long> update(
            @PathVariable Long postsId,
            @PathVariable Long id,
            @RequestBody CommentRequestDto.Request dto){
        commentService.update(postsId, id, dto);
        return ResponseEntity.ok(id);
    }*/

    /* DELETE */
    /*@DeleteMapping("/posts/{postsId}/comments/{id}")
    public ResponseEntity<Long> delete(
            @PathVariable Long postsId,
            @PathVariable Long id) {
        commentService.delete(postsId, id);
        return ResponseEntity.ok(id);
    }*/
}
