package com.project2.SpringTask.repository;

import com.project2.SpringTask.entity.Employee;
import com.project2.SpringTask.modelView.EmployeeModelView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepesotry extends MyBaseRepository<Employee, Long> {

@Query(value = "SELECT new com.project2.SpringTask.modelView.EmployeeModelView(emp.firstName,emp.lastName,emp.email,emp.phone,emp.address,dg.designationName) FROM Employee emp join emp.designation dg")
List<EmployeeModelView> getAllByDesignation();

}
