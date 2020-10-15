package com.starkmark.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starkmark.restapi.exception.ResourceNotFound;
import com.starkmark.restapi.model.Employee;
import com.starkmark.restapi.service.EmployeeService;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("employees")
	public List<Employee> getEmployees(){
		
		return service.employeeList();
	}
	@PostMapping("save")
	public Employee save(@RequestBody Employee emp) {
		return service.save(emp);
	}
	
	@GetMapping("employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
		Employee emp = service.getEmployee(id).orElseThrow(()-> new ResourceNotFound("Employee with the id " +id+ " not exist"));
		
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("employee/{id}")
	
	public ResponseEntity< Employee> updateEmp(@PathVariable Long id, @RequestBody Employee empDetail){
		Employee updated = service.getEmployee(id).orElseThrow(()-> new ResourceNotFound("Employee with the id " +id+ " not exist") );
		updated.setFirstname(empDetail.getFirstname());
		updated.setLastname(empDetail.getLastname());
		updated.setEmailId(empDetail.getEmailId());
		Employee saveUpdate = service.save(updated);
		return ResponseEntity.ok(saveUpdate);
		
	}
	
	@DeleteMapping("employee/{id}")
	
	public ResponseEntity<Map<String, Boolean>> deleteEmp(@PathVariable Long id){
		Employee emp = service.getEmployee(id).orElseThrow(()-> new ResourceNotFound("Employee with the id " +id+ " not exist"));
	     service.delete(emp);
	     Map<String, Boolean> response = new HashMap<>();
	     response.put("success", Boolean.TRUE);
	     return ResponseEntity.ok(response);
	}
	
}
