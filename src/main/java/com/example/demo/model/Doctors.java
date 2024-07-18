package com.example.demo.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Doctors {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorID;
	private String fullName;
	private String role;
	private String password;
	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Patients> patients;
	@JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedicalRecords> medicalRecords;

	public Doctors() {

	}
	
	
	public Doctors(String fullName, String username, String password, String email) {

		this.fullName = fullName;
		this.role = username;
		this.password = password;
		this.email = email;
	}


}
/*
DoctorID INT AUTO_INCREMENT PRIMARY KEY,
FullName VARCHAR(100) NOT NULL,
Username VARCHAR(50) NOT NULL UNIQUE,
Password VARCHAR(255) NOT NULL,
Email VARCHAR(100) NOT NULL
*/