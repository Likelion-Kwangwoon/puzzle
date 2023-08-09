package com.puzzle.likelion.config.jwt;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt") // application.yml 에서 가져오는 듯
public class JwtProperties {
    private String issuer;
    private String secretKey;
}