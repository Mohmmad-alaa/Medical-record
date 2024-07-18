package com.example.demo.security;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtIssuer {
	
	private final JwtProperties jwtProperties;
	
	public String issuer(Request request) {
		
		
		var now = Instant.now();
		return JWT.create()
				.withSubject(String.valueOf(request.userId))
				.withIssuedAt(now)
				.withExpiresAt(now.plus(jwtProperties.getTokenDuration()))
				.withClaim("e",request.email)
				.withClaim("au",request.roles)
				.sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
	}
	
	@Getter
    @Builder
    public static class Request {
        private final Long userId;
        private final String email;
        private final List<String> roles;
    }
	
}
