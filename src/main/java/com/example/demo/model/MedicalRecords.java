package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class MedicalRecords {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recordID;
	private Date recordDate;
	private String notes;
	
	
	
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctors doctor;
	
	
	public MedicalRecords() {
	}

	public MedicalRecords(Date recordDate, String notes) {
		this.recordDate = recordDate;
		this.notes = notes;
	}



	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public long getRecordID() {
		return recordID;
	}

	public void setRecordID(long recordID) {
		this.recordID = recordID;
	}
	
	
	
	
}
/*
 RecordID INT AUTO_INCREMENT PRIMARY KEY,
    PatientID INT NOT NULL,
    DoctorID INT NOT NULL,
    RecordDate DATE NOT NULL,
    Notes TEXT,
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (DoctorID) REFERENCES Doctors(DoctorID)
 */