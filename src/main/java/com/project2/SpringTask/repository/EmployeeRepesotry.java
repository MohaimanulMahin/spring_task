package com.project2.SpringTask.repository;

import com.project2.SpringTask.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepesotry extends MyBaseRepository<Employee, Long> {


}
