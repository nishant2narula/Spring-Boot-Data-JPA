package com.example.jpa.hospitalManagement.repository;

import com.example.jpa.hospitalManagement.dto.BloodGroupResponseEntity;
import com.example.jpa.hospitalManagement.entity.Patient;
import com.example.jpa.hospitalManagement.entity.type.BloodGroupType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    //Patient findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContaining(String name);

    @Query("Select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("Select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBirthDateAfter(@Param("birthDate")LocalDate birthDate);

    @Query("select new com.example.jpa.hospitalManagement.dto.BloodGroupResponseEntity(p.bloodGroup," +
            " Count(p)) from Patient p group by p.bloodGroup")
    //List<Object[]> countEachBloodType();
    List<BloodGroupResponseEntity> countEachBloodType();

    //@Query(value="Select * from patient",nativeQuery = true)
    //List<Patient> findAllPatient();

    @Query(value="Select * from patient",nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);


    @Transactional
    @Modifying
    @Query("Update Patient p set p.name=:name where p.id=:id")
    int updateNameWithId(@Param("name")String name, @Param("id")Long id);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    List<Patient> findAllPatientWithAppointment();


}
