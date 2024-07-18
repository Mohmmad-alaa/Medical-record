package com.example.demo.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {
    private final CustomUserDetails authorities;
	
public UserPrincipalAuthenticationToken(CustomUserDetails authorities) {
		super(authorities.getAuthorities());
		this.authorities = authorities;
		setAuthenticated(true);
	}

@Override
public Object getCredentials() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public CustomUserDetails getPrincipal() {
	// TODO Auto-generated method stub
	return authorities;
}



}
