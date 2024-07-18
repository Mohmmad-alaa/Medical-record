package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final CustomUserDetailsService customUserDetailService;
	private final JwtAuthenticationFilter authenticationFilter;

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

		http//.cors(cors -> cors.disable())
			.csrf(csrf -> csrf.disable())
			.securityMatcher("/**")
			.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.formLogin(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(r -> r
					.requestMatchers("/").permitAll()
					.requestMatchers("/auth/login/**").permitAll()
					.anyRequest().authenticated());
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return  NoOpPasswordEncoder.getInstance();
	}

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
		builder.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
		return builder.build();
	}

	
}
