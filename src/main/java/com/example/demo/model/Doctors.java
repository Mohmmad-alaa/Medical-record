package com.example.demo.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctors {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorID;
	private String fullName;
	private String username;
	private String password;
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
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public long getDoctorID() {
		return doctorID;
	}


	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Patients> getPatients() {
		return patients;
	}


	public void setPatients(Set<Patients> patients) {
		this.patients = patients;
	}


	public Set<MedicalRecords> getMedicalRecords() {
		return medicalRecords;
	}


	public void setMedicalRecords(Set<MedicalRecords> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}
/*
DoctorID INT AUTO_INCREMENT PRIMARY KEY,
FullName VARCHAR(100) NOT NULL,
Username VARCHAR(50) NOT NULL UNIQUE,
Password VARCHAR(255) NOT NULL,
Email VARCHAR(100) NOT NULL
*/