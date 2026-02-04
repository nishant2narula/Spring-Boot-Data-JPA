package com.example.jpa.hospitalManagement;

import com.example.jpa.hospitalManagement.entity.Appointment;
import com.example.jpa.hospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, Month.FEBRUARY, 17, 14, 59))
                .reason("Health Check-up")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment,1L, 2L);
        //System.out.println(newAppointment);

       var updatedAppointment =  appointmentService.reassignAppointment(newAppointment.getId(),3L);
        System.out.println(updatedAppointment);
    }

}
