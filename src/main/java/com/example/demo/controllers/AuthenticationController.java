package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.LoginRequest;
import com.example.demo.api.LoginResponse;
import com.example.demo.api.RegistrationDTO;
import com.example.demo.model.Doctors;
import com.example.demo.services.AuthenticationService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/register")
	public Doctors registerDoctor(@RequestBody RegistrationDTO  body) {
		return authenticationService.registerUser(body.getUsername(), body.getPassword());
	}
	
	@PostMapping("/login")
	public LoginResponse registerDoctor(@RequestBody LoginRequest request) {
		return authenticationService.attemptLogin(request.getEmail(), request.getPassword());
	}
}
