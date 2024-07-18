package com.example.demo.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.api.LoginResponse;
import com.example.demo.model.Doctors;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.security.JwtIssuer;

@Service
//@RequiredArgsConstructor
public class AuthenticationService {

	private final JwtIssuer jwtIssuer;
	private final AuthenticationManager authenticationManager;


    public AuthenticationService(JwtIssuer jwtIssuer, AuthenticationManager authenticationManager) {
        this.jwtIssuer = jwtIssuer;
        this.authenticationManager = authenticationManager;
    }
	
	public LoginResponse attemptLogin(String username, String password) {

		var authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		var principal = (CustomUserDetails) authenticate.getPrincipal();

		var token = jwtIssuer.issuer(JwtIssuer.Request.builder().userId(principal.getUserId())
				.email(principal.getUsername())
				.roles(principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()).build());

		return LoginResponse.builder().token(token).build();
	}

	
	public Doctors registerUser(String username, String password) {

		return null;
	}

}
