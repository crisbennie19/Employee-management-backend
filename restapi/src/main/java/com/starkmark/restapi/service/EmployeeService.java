package com.starkmark.restapi.service;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starkmark.restapi.model.Employee;
import com.starkmark.restapi.repository.EmployeRepo;
@Service
public class EmployeeService   {

	@Autowired
	EmployeRepo repo;
	
	public List<Employee> employeeList(){
		
		return repo.findAll();
	}
	public Employee save(Employee emp) {
		return repo.save(emp);
	}
	public Optional<Employee> getEmployee(Long id) {
		return repo.findById(id);
	}
	public void delete(Employee emp) {
		
		repo.delete(emp);
	
	}
}
