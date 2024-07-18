package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors, Long> {
	
	Optional<Doctors> findByEmail(String username);
	
	@Query(value = "SELECT * FROM `doctors` WHERE `email` = :email AND `password` = :password", nativeQuery = true)
	Doctors getDoctorByEmailAndPassword(String email, String password);
}
