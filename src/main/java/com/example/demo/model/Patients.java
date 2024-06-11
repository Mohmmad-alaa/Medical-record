package com.example.demo.model;

import java.util.Date;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientID;
	private String fullName;
	private String nationalID;
	private Date dateOfBirth;
	private String gender;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctors doctor;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedicalRecords> medicalRecords;

	public Patients() {
	}

	public Patients(String fullName, String nationalID, Date dateOfBirth, String gender) {

		this.fullName = fullName;
		this.nationalID = nationalID;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public Doctors getDoctorID() {
		return doctor;
	}

	public void setDoctorID(Doctors doctorID) {
		this.doctor = doctorID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

}
/*
 *  PatientID INT AUTO_INCREMENT PRIMARY KEY,
 *  DoctorID INT NOT NULL, FullName
 * 	VARCHAR(100) NOT NULL,
 *  NationalID VARCHAR(50) NOT NULL,
 *  DateOfBirth DATE NOT NULL,
 *  Gender ENUM('ذكر', 'أنثى') NOT NULL,
 *  FOREIGN KEY (DoctorID) REFERENCES
 *  Doctors(DoctorID)
 * 
 */