package com.example.demo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
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