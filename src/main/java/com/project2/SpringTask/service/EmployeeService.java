package com.project2.SpringTask.service;

import com.project2.SpringTask.dto.EmployeeDto;
import com.project2.SpringTask.entity.Designation;
import com.project2.SpringTask.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
  List<Employee> getAllEmployees();

  Employee saveEmployee(EmployeeDto employee, Designation designation);

  Optional<Employee> getEmployeeById(Long id);

  Employee updateEmployee(long id,EmployeeDto employeeDto);
  void updateDesignation(long id);

  void deleteEmployeeById(Long id);
}
