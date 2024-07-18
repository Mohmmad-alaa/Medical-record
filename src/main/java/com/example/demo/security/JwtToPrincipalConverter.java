package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtToPrincipalConverter  {
	
	public CustomUserDetails convert(DecodedJWT jwt) {
			List<GrantedAuthority> authorityList  = getClaimOrEmptyList(jwt , "au").stream()
					.map(SimpleGrantedAuthority::new)
					.collect(Collectors.toList());

			
			return CustomUserDetails.builder()
					.userId(Long.parseLong(jwt.getSubject()))
					.username(jwt.getClaim("e").asString())
					.roles(authorityList)
					.build();
			
					
			
	}
	
	private List<String> getClaimOrEmptyList(DecodedJWT jwt,String claim){
		if(jwt.getClaim(claim).isNull()) return List.of();
		return jwt.getClaim(claim).asList(String.class);
	}
	/*
	private List<SimpleGrantedAuthority> getClaimOrEmptyList(DecodedJWT jwt){
		if (jwt.getClaim("au").isNull()) return List.of();
		return jwt.getClaim("au").asList(SimpleGrantedAuthority.class);
	}
	*/
	
}