package com.project2.SpringTask.service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.project2.SpringTask.dto.EmployeeDto;
import com.project2.SpringTask.entity.Designation;
import com.project2.SpringTask.entity.Employee;
import com.project2.SpringTask.repository.EmployeeRepesotry;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepesotry employeeRepesotry;

  public EmployeeServiceImpl(EmployeeRepesotry employeeRepesotry){
    super();
    this.employeeRepesotry=employeeRepesotry;
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepesotry.findAll();
  }

  @Override
  public Employee saveEmployee(EmployeeDto empdto, Designation designation) {
    Employee emp=new Employee();
    emp.setFirstName(empdto.getFirstName());
    emp.setLastName(empdto.getLastName());
    emp.setPhone(empdto.getPhone());
    emp.setEmail(empdto.getEmail());
    emp.setAddress(empdto.getAddress());
    emp.setDesignation(designation);

    return employeeRepesotry.save(emp);
  }

//  @Override
//  public Employee saveEmployee(Employee employee) {
//    return employeeRepesotry.save(employee);
//  }

  @Override
  public Optional<Employee> getEmployeeById(Long id) {
    return employeeRepesotry.findById(id);
  }
  @Override
  public Employee updateEmployee(long id,EmployeeDto employeeDto) {
    Employee existingEmp=new Employee();
    if(this.getEmployeeById(id).isPresent()){
      existingEmp=this.getEmployeeById(id).get();
      existingEmp.setAddress(employeeDto.getAddress());
      existingEmp.setEmail(employeeDto.getEmail());
      existingEmp.setPhone(employeeDto.getPhone());
      existingEmp.setFirstName(employeeDto.getFirstName());
      existingEmp.setLastName(employeeDto.getLastName());

    }
    return employeeRepesotry.save(existingEmp);
  }

  @Override
  public void updateDesignation(long id) {
    if(this.getEmployeeById(id).isPresent()){
      Employee existingEmp=this.getEmployeeById(id).get();
      existingEmp.setDesignation(null);
      employeeRepesotry.save(existingEmp);
    }
  }

  @Override
  public void deleteEmployeeById(Long id) {
      employeeRepesotry.deleteById(id);
  }



}
