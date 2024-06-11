// PatientService.java
package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patients;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patients> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patients getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patients savePatient(Patients patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
