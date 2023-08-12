//package com.puzzle.likelion.service;
//
//import com.puzzle.likelion.config.jwt.TokenProvider;
//import com.puzzle.likelion.entity.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//
//@Service
//@RequiredArgsConstructor
//public class TokenService {
//    private final TokenProvider tokenProvider;
//    private final RefreshTokenService refreshTokenService;
//    private final UserService userService;
//
//    public String createNewAccessToken(String refreshToken) {
//        if (!tokenProvider.validToken(refreshToken)) {
//            throw new IllegalArgumentException("Unexpected Token");
//        }
//        // 전달받은 리프레시 토큰으로 토큰 유효성 검사 후 사용자 ID를 찾아 새로운 액세스 토큰 생성
//
//        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
//        User user = userService.findById(userId);
//
//        return tokenProvider.generateToken(user, Duration.ofHours(2));
//    }
//}
