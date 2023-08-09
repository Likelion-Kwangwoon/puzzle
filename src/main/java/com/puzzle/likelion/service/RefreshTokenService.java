package com.puzzle.likelion.service;

import com.puzzle.likelion.entity.RefreshToken;
import com.puzzle.likelion.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }
}
