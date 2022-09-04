package com.project2.SpringTask;

import com.project2.SpringTask.modelView.EmployeeModelView;
import com.project2.SpringTask.repository.EmployeeRepesotry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class SpringTaskApplicationTests {
	@Autowired
private EmployeeRepesotry employeeRepesotry;
	@Test
	void contextLoads() {
//	List<EmployeeModelView> employeeModelViews= employeeRepesotry.getAllByDesignation().stream().toList();
//		System.out.println();
//		employeeModelViews.forEach(System.out::println);


	}

}
