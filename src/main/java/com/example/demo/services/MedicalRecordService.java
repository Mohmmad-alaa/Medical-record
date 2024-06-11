// MedicalRecordService.java
package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MedicalRecords;
import com.example.demo.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecords> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecords getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id).orElse(null);
    }

    public MedicalRecords saveMedicalRecord(MedicalRecords medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public void deleteMedicalRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }
    
    public List<MedicalRecords> getMedicalRecordsByPatientid(long id){
		return medicalRecordRepository.getMedicalRecordsByPatientid(id);  	
    }
}
