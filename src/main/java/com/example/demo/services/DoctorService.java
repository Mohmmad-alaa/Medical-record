// DoctorService.java
package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctors;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctors> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctors getDoctorById(Long id) {
		return doctorRepository.findById(id).orElse(null);
	}

	public Doctors saveDoctor(Doctors doctor) {
		return doctorRepository.save(doctor);
	}

	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}

	public Doctors getDoctorByEmailAndPassword(String email, String password) {
		return doctorRepository.getDoctorByEmailAndPassword(email, password);
	}
}
