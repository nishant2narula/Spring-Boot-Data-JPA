package com.example.jpa.hospitalManagement.repository;

import com.example.jpa.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}