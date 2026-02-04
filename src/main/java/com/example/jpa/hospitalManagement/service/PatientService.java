package com.example.jpa.hospitalManagement.service;

import com.example.jpa.hospitalManagement.repository.PatientRepository;
import com.example.jpa.hospitalManagement.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional()
    public Patient getPatientById(Long id) {

      Patient p1= patientRepository.findById(id).orElseThrow();

        Patient p2= patientRepository.findById(id).orElseThrow();

        return p1;

    }

}
