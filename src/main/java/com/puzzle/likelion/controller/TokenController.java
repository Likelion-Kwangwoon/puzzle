//package com.puzzle.likelion.controller;
//
//import com.puzzle.likelion.dto.CreateAccessTokenRequest;
//import com.puzzle.likelion.dto.CreateAccessTokenResponse;
//import com.puzzle.likelion.service.TokenService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class TokenController {
//    private final TokenService tokenService;
//
//
//    // 해당 요청을 받으면 리프레시 토큰을 통해 새로운 토큰 생성 후 반환
//    @PostMapping("/api/token")
//    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(@RequestBody
//                                                                          CreateAccessTokenRequest request) {
//        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new CreateAccessTokenResponse(newAccessToken));
//    }
//}
