package com.example.jpa.hospitalManagement.service;


import com.example.jpa.hospitalManagement.entity.Insurance;
import com.example.jpa.hospitalManagement.entity.Patient;
import com.example.jpa.hospitalManagement.repository.InsuranceRepository;
import com.example.jpa.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

   @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+patientId));
        patient.setInsurance(insurance);

        insurance.setPatient(patient); // bidirectional consistency maintenance

        return patient;

    }

    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(null);
        return patient;
    }





}
