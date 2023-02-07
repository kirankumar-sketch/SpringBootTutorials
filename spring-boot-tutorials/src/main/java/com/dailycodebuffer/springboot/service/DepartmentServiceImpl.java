package com.dailycodebuffer.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dailycodebuffer.springboot.entity.Department;
import com.dailycodebuffer.springboot.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.repository.DeparmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DeparmentRepository deparmentRepo;
	
	@Override
	public Department saveDepartment(Department department) {
		
		return deparmentRepo.save(department);
		
	}

	@Override
	public Department getDeparmentById(Long departmentId) throws DepartmentNotFoundException {
		
		Department dep=deparmentRepo.findByDepartmentId(departmentId);
		
		  if(dep ==null) { 
			  throw new DepartmentNotFoundException("Department is not found");
		  }
		 
	    return dep;
	}

	
	@Override
	public List<Department> getAllDeparments() {
		
		return deparmentRepo.findAll();
	}

	@Override
	public void deleteByDepartmentId(Long departmentId) {
		deparmentRepo.deleteById(departmentId);;
		
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department dep=deparmentRepo.getById(departmentId);
		if(dep !=null) {
		   dep.setDepartmentAddress(department.getDepartmentAddress());
		   dep.setDepartmentCode(department.getDepartmentCode());
		   dep.setDepartmentName(department.getDepartmentName());
		}
		return deparmentRepo.save(dep);
	}
	
	

}
