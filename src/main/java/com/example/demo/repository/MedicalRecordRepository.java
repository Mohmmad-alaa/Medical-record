package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.MedicalRecords;


public interface MedicalRecordRepository extends JpaRepository<MedicalRecords, Long> {
	@Query(value = "SELECT * FROM `medical_records` WHERE `patient_id` = :id",nativeQuery = true)
	List<MedicalRecords> getMedicalRecordsByPatientid(long id);

}
