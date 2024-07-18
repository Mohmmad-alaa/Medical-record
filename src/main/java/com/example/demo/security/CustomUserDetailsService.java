package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctors;
import com.example.demo.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private  DoctorRepository doctorRepository;
	private final static String ROLE_PREFIX = "ROLE_";
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Doctors> email =  this.doctorRepository.findByEmail(username);
		email.orElseThrow(()->new UsernameNotFoundException("User not found"));
		
		String password = email.get().getPassword();
		String role = email.get().getEmail();
		role = ROLE_PREFIX + role;
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(role));
		
		
		
		return new CustomUserDetails(email.get().getDoctorID(),username, password, roles);
	}
	
	public String getPassword(String password) {
		return password;
	}

}
