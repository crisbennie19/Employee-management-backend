package com.starkmark.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starkmark.restapi.model.Employee;

@Repository
public interface EmployeRepo extends JpaRepository<Employee, Long>{

}
