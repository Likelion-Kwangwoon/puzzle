package com.puzzle.likelion.service;


import com.puzzle.likelion.dto.AddUserRequest;
import com.puzzle.likelion.entity.User;
import com.puzzle.likelion.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long save(AddUserRequest dto) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail()) // 패스워드 암호화
                .password(encoder.encode(dto.getPassword()))
                .build()).getId();
    }

    /*public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("Unexpected user"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }*/
}
