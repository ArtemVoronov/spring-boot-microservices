package org.unknown;

//TODO: clean
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.unknown.model.department.Department;
import org.unknown.model.department.DepartmentRepository;
import org.unknown.model.employee.Employee;
import org.unknown.model.employee.EmployeeRepository;
import org.unknown.model.position.Position;
import org.unknown.model.position.PositionRepository;

import java.util.Date;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	//TODO: clean
//  @Bean
//  public CommandLineRunner demo(DepartmentRepository departmentRepository, PositionRepository positionRepository,
//                                EmployeeRepository employeeRepository) {
//    return (args) -> {
//      Department prod = departmentRepository.save(new Department("Production"));
//      departmentRepository.save(new Department("QA"));
//      departmentRepository.save(new Department("Marketing"));
//      departmentRepository.save(new Department("Support"));
//
//
//      Position programmer = positionRepository.save(new Position("Software engineer"));
//      positionRepository.save(new Position("Support engineer"));
//      positionRepository.save(new Position("QA engineer"));
//      Position boss = positionRepository.save(new Position("Boss"));
//
//      employeeRepository.save(new Employee("Bob", new Date(), boss, prod, 1100000));
//      employeeRepository.save(new Employee("Tom", new Date(), programmer, prod, 500000));
//      employeeRepository.save(new Employee("Joe", new Date(), programmer, prod, 400000));
//
//    };
//  }
}
