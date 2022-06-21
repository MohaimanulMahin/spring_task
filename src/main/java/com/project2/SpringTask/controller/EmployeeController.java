package com.project2.SpringTask.controller;

import com.project2.SpringTask.dto.EmployeeDto;
import com.project2.SpringTask.entity.Designation;
import com.project2.SpringTask.entity.Employee;

import com.project2.SpringTask.exception.EmployeeNotFoundException;
import com.project2.SpringTask.service.DesignationService;
import com.project2.SpringTask.service.EmployeeService;
import com.project2.SpringTask.utils.FilterJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@Slf4j
public class EmployeeController {
  private final EmployeeService employeeService;
  private final DesignationService designationService;
  private final FilterJson filterJson;

  @Value("${welcome.message}")
  private String message;


  public EmployeeController(EmployeeService employeeService, DesignationService designationService, FilterJson filterJson) {
    super();
    this.employeeService = employeeService;
    this.designationService=designationService;
    this.filterJson = filterJson;
  }

  @GetMapping("/")
  public String frontPage(){
    return message;
  }

  @GetMapping("/list-emp")
  public  ResponseEntity<?> ListEmployee(){
    try{
      Set<String> hash_Set = new HashSet<String>();
      hash_Set.add("lastName");
      hash_Set.add("email");
      List<Employee> employeesList=employeeService.getAllEmployees();
      List<EmployeeDto> employeeDtos=  employeesList.stream()
              .map(entity->new EmployeeDto(entity.getFirstName(),entity.getLastName(),entity.getEmail(),
                      entity.getPhone(),entity.getAddress(),entity.getDesignationId()))
              .collect(Collectors.toList());
      MappingJacksonValue mapping = filterJson.getMappingJacksonValue(employeeDtos,hash_Set);
      return  ResponseEntity.ok().body(mapping);
    }
    catch (Exception e){
      log.error("Error message: {}",String.valueOf(e));
      return  ResponseEntity.badRequest().body(List.of("msg:Something Wrong.Error: ",e));
    }
  }

//  @GetMapping(value = "/specific-emp/{empId}",params = "version=1")
  @GetMapping(value = "/specific-emp/{empId}")
  public ResponseEntity<?> specificEmployeeDetails(@PathVariable(value = "empId") long id){

    Optional<Employee> emp=employeeService.getEmployeeById(id);
    System.out.println("employee "+emp);
      if(emp.isEmpty()){
        throw new EmployeeNotFoundException("Employee Not found");
      }
      EmployeeDto employeeDto=new EmployeeDto();
      employeeDto.setFirstName(emp.get().getFirstName());
      employeeDto.setLastName(emp.get().getLastName());
      employeeDto.setEmail(emp.get().getEmail());
      employeeDto.setAddress(emp.get().getAddress());
    Set<String> hash_Set = new HashSet<String>();
    hash_Set.add("lastName");
    hash_Set.add("email");
    MappingJacksonValue mapping = filterJson.getMappingJacksonValue(List.of(employeeDto),hash_Set);
    System.out.println("mapping");
    return ResponseEntity.ok().body(mapping);
  }




//  @PostMapping(value = "/emp-create",headers = "X-API-VERSION-1")
  @PostMapping(value = "/emp-create")
  public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto employee){
//    try{
      Designation designation = designationService.getDesignationById(employee.getDesignationId());
//      employee.addDesignation(designation);
     Employee employee1= employeeService.saveEmployee(employee,designation);
      return  ResponseEntity.ok().body(List.of("msg:Employee is created",employee1));
//    }catch (Exception e){
//      log.error("Error message: {}",String.valueOf(e));
//      return  ResponseEntity.badRequest().body(List.of("Something went Wrong.Error: ",e));
//    }
  }

//  @PostMapping(value = "/emp-update/{empId}",produces = "application/vnd.company.app-v1+json")
  @PostMapping(value = "/emp-update/{empId}")
  //pass header Accept:application/vnd.company.app-v1+json
  public ResponseEntity<?> EmployeeUpdate(@PathVariable(value = "empId") long id,@RequestBody EmployeeDto employeeDto){
    try{

      Employee updateEmp=employeeService.updateEmployee(id,employeeDto);
      return ResponseEntity.ok().body(updateEmp);
    }
    catch (Exception e){
      log.error("Error message: {}",String.valueOf(e));
      return ResponseEntity.badRequest().body(e);
    }
  }

  @PostMapping("/emp-delete/{empId}")
  public ResponseEntity<?> EmployeeDelete(@PathVariable(value = "empId") long id){
    try{
      employeeService.updateDesignation(id);
      employeeService.deleteEmployeeById(id);
      return ResponseEntity.ok().body("msg:Employee Delete");
    }
    catch (Exception e){
      log.error("Error message: {}",String.valueOf(e));
      return ResponseEntity.badRequest().body(List.of("Something went Wrong.Error: ",e));
    }
  }
}
