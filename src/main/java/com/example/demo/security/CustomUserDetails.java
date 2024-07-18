package com.example.demo.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomUserDetails implements UserDetails {

	private final Long userId;
	private final String username;
	@JsonIgnore
	private final String password;
	private final List<GrantedAuthority> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // <-- Very important to not forget
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // <-- Very important to not forget
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // <-- Very important to not forget
	}

	@Override
	public boolean isEnabled() {
		return true; // <-- Very important to not forget
	}

}
