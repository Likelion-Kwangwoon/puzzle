//package com.puzzle.likelion.config;
//
//import com.puzzle.likelion.config.jwt.TokenProvider;
//import com.puzzle.likelion.config.oauth.OAuth2AuthorizationRequestBasedOnCookieRepository;
//import com.puzzle.likelion.config.oauth.OAuth2SuccessHandler;
//import com.puzzle.likelion.config.oauth.OAuth2UserCustomService;
//import com.puzzle.likelion.repository.RefreshTokenRepository;
//import com.puzzle.likelion.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
//
//@RequiredArgsConstructor
//@Configuration
//public class WebOAuthSecurityConfig {
//
//    private final OAuth2UserCustomService oAuth2UserCustomService;
//    private final TokenProvider tokenProvider;
//    private final RefreshTokenRepository refreshTokenRepository;
//    private final UserService userService;
//
//    @Bean
//    public WebSecurityCustomizer configure() {
//        return (web) -> web.ignoring()
//                .requestMatchers(toH2Console())
//                .requestMatchers("/img/**", "/css/**", "/static.js/**");
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        // 기본적인 보안 설정 구성
//        http.csrf().disable()
//                .httpBasic().disable()
//                .formLogin().disable()
//                .logout().disable();
//
//        // 세션 관리를 무상태로 설정
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // 토큰 인증 필터 추가
//        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//
//        // url에 따른 인가 규칙 설정
//        http.authorizeRequests()
//                .requestMatchers("/api/token").permitAll() // 토큰 재발급 url은 인증 없이 접근
//                .requestMatchers("/api/**").authenticated() // 나머지는 인증 필요
//                .anyRequest().permitAll();
//
//
//        // 로그인 설정 구성
//        http.oauth2Login()
//                .loginPage("/login")
//                .authorizationEndpoint()
//                // 요청과 관련된 상태 저장
//                .authorizationRequestRepository(oAuth2AuthorizationRequestBasedOnCookieRepository())
//                .and()
//                .successHandler(oAuth2SuccessHandler()) // 인증 성공 시 실행할 핸들러
//                .userInfoEndpoint()
//                .userService(oAuth2UserCustomService);
//
//        http.logout()
//                .logoutSuccessUrl("/login");
//
//
//        // 인증되지 않은 사용자에 대한 처리
//        // api로 시작하는 url의 경우 401 상태 코드를 반환
//        http.exceptionHandling()
//                .defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
//                        new AntPathRequestMatcher("/api/**"));
//
//
//        return http.build();
//    }
//
//
//    @Bean
//    public OAuth2SuccessHandler oAuth2SuccessHandler() {
//        return new OAuth2SuccessHandler(tokenProvider,
//                refreshTokenRepository,
//                oAuth2AuthorizationRequestBasedOnCookieRepository(),
//                userService
//        );
//    }
//
//    @Bean
//    public TokenAuthenticationFilter tokenAuthenticationFilter() {
//        return new TokenAuthenticationFilter(tokenProvider);
//    }
//
//    @Bean
//    public OAuth2AuthorizationRequestBasedOnCookieRepository oAuth2AuthorizationRequestBasedOnCookieRepository() {
//        return new OAuth2AuthorizationRequestBasedOnCookieRepository();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
