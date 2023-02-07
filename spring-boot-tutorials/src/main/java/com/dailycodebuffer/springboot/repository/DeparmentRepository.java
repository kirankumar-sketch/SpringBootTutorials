package com.dailycodebuffer.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.springboot.entity.Department;

@Repository
public interface DeparmentRepository extends JpaRepository<Department, Long>{

	Department findByDepartmentId(Long departmentId);

	void deleteByDepartmentId(Long departmentId);

}
