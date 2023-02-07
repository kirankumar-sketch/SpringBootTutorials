package com.dailycodebuffer.springboot.service;

import java.util.List;

import com.dailycodebuffer.springboot.entity.Department;
import com.dailycodebuffer.springboot.error.DepartmentNotFoundException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	Department getDeparmentById(Long departmentId) throws DepartmentNotFoundException;

	

	List<Department> getAllDeparments();

	void deleteByDepartmentId(Long departmentId);

	Department updateDepartment(Long departmentId, Department department);

}
