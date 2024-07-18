// DoctorController.java
package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctors;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.services.DoctorService;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private CustomUserDetailsService detailsService; 
	@GetMapping
	public List<Doctors> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	@GetMapping("/{id}")
	public Doctors getDoctorById(@PathVariable Long id) {
		return doctorService.getDoctorById(id);
	}

	@PostMapping
	public Doctors createDoctor(@RequestBody Doctors doctor) {
		return doctorService.saveDoctor(doctor);
	}

	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
	}

	/*@GetMapping("/login")
	public Doctors getDoctorByEmailAndPassword(@RequestParam(required = true) String email, @RequestParam(required = true) String password) {
		return doctorService.getDoctorByEmailAndPassword(email, password);
	}*/
	@PostMapping("/login")
	public UserDetails loadUserByUsername(@RequestParam(required = true) String email, @RequestParam(required = true) String password) {
		detailsService.getPassword(password);
		return detailsService.loadUserByUsername(email);
	}
}
