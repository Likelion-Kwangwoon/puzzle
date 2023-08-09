package com.puzzle.likelion.config.oauth;


import com.puzzle.likelion.config.jwt.TokenProvider;
import com.puzzle.likelion.entity.RefreshToken;
import com.puzzle.likelion.entity.User;
import com.puzzle.likelion.repository.RefreshTokenRepository;
import com.puzzle.likelion.service.UserService;
import com.puzzle.likelion.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;

@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public static final String REFRESH_TOKEN_COOKIE_NAME = "refresh_token";
    public static final Duration REFRESH_TOKEN_DURATION = Duration.ofDays(14);
    public static final Duration ACCESS_TOKEN_DURATION = Duration.ofDays(1);
    public static final String REDIRECT_PATH = "/articles";

    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final OAuth2AuthorizationRequestBasedOnCookieRepository authorizationRequestRepository;
    private final UserService userService;


    // 사용자가 인증 성공 시 실행
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response
            , Authentication authentication) throws IOException {

        // 사용자 정보 가져오기 (공급자=구글 로부터)
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        // 사용자 정보로부터 이메일 추출하여 사용자 찾기
        User user = userService.findByEmail((String) oAuth2User.getAttributes().get("email"));

        // 새로운 리프레시 토큰 생성 후 저장, 생성한 토큰 쿠키에 추가하여 클라이언트에 전달
        String refreshToken = tokenProvider.generateToken(user, REFRESH_TOKEN_DURATION);
        saveRefreshToken(user.getId(), refreshToken);
        addRefreshTokenToCookie(request, response, refreshToken);

        // 토큰 생성, 타겟 url 생성
        String accessToken = tokenProvider.generateToken(user, ACCESS_TOKEN_DURATION);
        String targetUrl = getTargetUrl(accessToken);

        // 인증과 관련된 데이터 클리어
        clearAuthenticationAttributes(request, response);

        // 생성된 대상 url로 redirect
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }


    // 새로 생성되거나 업데이트 된 리프레시 토큰 저장 메서드
    private void saveRefreshToken(Long userId, String newRefreshToken) {
        RefreshToken refreshToken = refreshTokenRepository.findByUserId(userId)
                .map(entity -> entity.update(newRefreshToken))
                .orElse(new RefreshToken(userId, newRefreshToken)); // 없다면 새로 만듦

        refreshTokenRepository.save(refreshToken);
        // 여기 이해 안 감 .. 왜 업데이트한 걸 또 다시 저장?
    }

    // 생성된 리프레시 토큰을 쿠키에 저장
    private void addRefreshTokenToCookie(HttpServletRequest request, HttpServletResponse response, String refreshToken) {
        int cookieMaxAge = (int) REFRESH_TOKEN_DURATION.toSeconds();

        CookieUtil.deleteCookie(request, response, REFRESH_TOKEN_COOKIE_NAME);
        // 이미 해당 이름의 쿠키가 존재한다면 삭제

        CookieUtil.addCookie(response, REFRESH_TOKEN_COOKIE_NAME, refreshToken, cookieMaxAge);
        // 새로운 리프레시 토큰을 쿠키에 추가
    }

    // 인증 관련 설정값, 쿠키 제거
    private void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        super.clearAuthenticationAttributes(request);
        authorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
    }

    // 액세스 토큰을 패스에 추가
    private String getTargetUrl(String token) {
        return UriComponentsBuilder.fromUriString(REDIRECT_PATH)
                .queryParam("token", token)
                .build()
                .toUriString(); // 액세스 토큰을 포함하여 url 생성
    }
}