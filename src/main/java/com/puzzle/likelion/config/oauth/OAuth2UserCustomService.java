package com.puzzle.likelion.config.oauth;

import com.puzzle.likelion.entity.User;
import com.puzzle.likelion.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2UserCustomService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        saveOrUpdate(user);
        return user;
    }

    private User saveOrUpdate(OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String email = (String) attributes.get("email");
        String name = (String)attributes.get("name");
        User user = userRepository.findByEmail(email)
                .map(entity -> entity.update(name)) // 있다면 업데이트
                .orElse(User.builder() // 없다면 builer 객체로  생성
                        .email(email)
                        .nickname(name)
                        .build());
        return userRepository.save(user);
    }
}
