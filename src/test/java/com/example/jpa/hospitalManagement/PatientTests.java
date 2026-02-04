package com.example.jpa.hospitalManagement;

import com.example.jpa.hospitalManagement.repository.PatientRepository;
import com.example.jpa.hospitalManagement.service.PatientService;
import com.example.jpa.hospitalManagement.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        //List<Patient> patientList = patientRepository.findAll();
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethod() {
        //Patient patient = patientService.getPatientById(1L);

        //Patient patient = patientRepository.findByName("Diya Patel");

       // LocalDate searchDate = LocalDate.of(1995, 8, 20);

        //List<Patient> patientList = patientRepository.findByBirthDateOrEmail(searchDate,"dikshant.verma@example.com" );

        LocalDate startDate = LocalDate.of(1989, 1, 1);

        LocalDate endDate = LocalDate.of(2000, 1, 1);

        LocalDate birthDate = LocalDate.of(1989, 1, 1);
       //List<Patient> patientList = patientRepository.findByBirthDateBetween(startDate,endDate);

        //List<Patient> patientList = patientRepository.findByNameContaining("Di");

        //List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

        //List<Patient> patientList = patientRepository.findByBirthDateAfter(birthDate);

      //  List<Object[]> patientBloodGroupList = patientRepository.countEachBloodType();

       /* for(Object[] objects:patientBloodGroupList) {

            System.out.println(objects[0]+" "+objects[1]);
        } */

       /* List<Patient> patientList = patientRepository.findAllPatient();

        for(Patient p:patientList) {

           System.out.println(p);
       }

        int rowstoUpdate = patientRepository.updateNameWithId("Arav Sharma",1L);
        System.out.println(rowstoUpdate); */

      /*  List<BloodGroupResponseEntity> patientBloodGroupList = patientRepository.countEachBloodType();

        for(BloodGroupResponseEntity patientBloodGroup:patientBloodGroupList) {

            System.out.println(patientBloodGroup);
        }*/

        // Pagination
       /* Pageable pageable = PageRequest.of(0, 2);
             Page<Patient> patientList = patientRepository.findAllPatient(pageable);*/


        // Sorting in Pagination
        Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));
        Page<Patient> patientList = patientRepository.findAllPatient(pageable);

        for(Patient p:patientList) {

           System.out.println(p);
       }
    }



}
