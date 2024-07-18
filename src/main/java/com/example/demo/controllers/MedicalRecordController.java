// MedicalRecordController.java
package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MedicalRecords;
import com.example.demo.services.MedicalRecordService;

@RestController
@RequestMapping("/api/medicalRecords")
@CrossOrigin(origins = "*")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping
    public List<MedicalRecords> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }

	/*
	 * @GetMapping("/{id}") public MedicalRecords getMedicalRecordById(@PathVariable
	 * Long id) { return medicalRecordService.getMedicalRecordById(id); }
	 */

    @PostMapping
    public MedicalRecords createMedicalRecord(@RequestBody MedicalRecords medicalRecord) {
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
    }
    
    @GetMapping("/{id}")
    public List<MedicalRecords> getMedicalRecordsByPatientid(@PathVariable long id){
		return medicalRecordService.getMedicalRecordsByPatientid(id);  	
    }
}
