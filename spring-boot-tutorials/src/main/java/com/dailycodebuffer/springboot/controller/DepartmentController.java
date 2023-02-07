package com.dailycodebuffer.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.springboot.entity.Department;
import com.dailycodebuffer.springboot.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/saveDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		System.out.println("saveDepatment");
		return departmentService.saveDepartment(department);	 
	}
	
	@GetMapping("/{departmentId}")
	public Department getDeparmentById(@PathVariable("departmentId") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.getDeparmentById(departmentId);
	}
	@GetMapping("/departments")
	public List<Department> getDeparments() {
		return departmentService.getAllDeparments();
	}
	@DeleteMapping("/{departmentId}")
	 public String deleteDepartmentById(@PathVariable("departmentId") Long departmentId){
		departmentService.deleteByDepartmentId(departmentId);
		return "Department id deleted successfully";
	}
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,
										@RequestBody Department department) {
		
		return departmentService.updateDepartment(departmentId,department);
	}
}
