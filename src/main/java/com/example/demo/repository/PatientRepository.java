package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Patients;


public interface PatientRepository extends JpaRepository<Patients, Long> {
	@Query(value = "SELECT * FROM `patients` WHERE `doctor_id` = :id ",nativeQuery = true)
	List<Patients> getPatientsByDoctorId(long id);
}
