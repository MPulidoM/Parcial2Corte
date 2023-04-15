package com.example.demo;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			System.out.println("\nDeleting employees....");
			employeeService.deleteEmployees();

			System.out.println("Adding employees....\n");
			employeeService.addEmployee(new Employee("Mariana", "Pulido", "Salesman", 63000.00, LocalDate.of(2002, 12,21)));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Salesman", 63000.00, LocalDate.of(2002, 5,12)));

			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));



		};
	}
}

