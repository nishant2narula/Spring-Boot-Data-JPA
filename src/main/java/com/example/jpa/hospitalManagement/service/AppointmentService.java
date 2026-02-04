package com.example.jpa.hospitalManagement.service;
import com.example.jpa.hospitalManagement.entity.Appointment;
import com.example.jpa.hospitalManagement.entity.Doctor;
import com.example.jpa.hospitalManagement.entity.Patient;
import com.example.jpa.hospitalManagement.repository.AppointmentRepository;
import com.example.jpa.hospitalManagement.repository.DoctorRepository;
import com.example.jpa.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(EntityNotFoundException::new);
        Patient patient = patientRepository.findById(patientId).orElseThrow(EntityNotFoundException::new);

        if(appointment.getId()!=null) throw new IllegalArgumentException("Appointment already exists");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment); // To Maintain consistency

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reassignAppointment(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        return appointment;
    }



}
