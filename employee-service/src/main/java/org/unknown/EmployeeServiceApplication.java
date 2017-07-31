package org.unknown;

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
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

  @Bean
  public CommandLineRunner demo(DepartmentRepository departmentRepository, PositionRepository positionRepository,
                                EmployeeRepository employeeRepository) {
    return (args) -> {

      boolean unitTestingEnabled = System.getProperty("unit.testing.enabled") == null ? false : Boolean.parseBoolean(System.getProperty("unit.testing.enabled"));
      if (unitTestingEnabled)
        return;

      Department prod = departmentRepository.save(new Department("Production"));
      Department qa = departmentRepository.save(new Department("QA"));
      Department support = departmentRepository.save(new Department("Support"));

      Position programmer = positionRepository.save(new Position("Software engineer"));
      Position admin = positionRepository.save(new Position("Support engineer"));
      Position tester = positionRepository.save(new Position("QA engineer"));
      Position boss = positionRepository.save(new Position("Boss"));

      Date startDate = convert(LocalDate.of(2017, 2, 15));

      employeeRepository.save(new Employee("Bob", startDate, boss, prod, 1500000));

      employeeRepository.save(new Employee("Tom", startDate, programmer, prod, 500000));
      employeeRepository.save(new Employee("Joe", startDate, programmer, prod, 400000));
      employeeRepository.save(new Employee("Kama", startDate, convert(LocalDate.of(2017, 5, 13)), programmer, prod, 300000));

      employeeRepository.save(new Employee("Mary", startDate, tester, qa, 550000));
      employeeRepository.save(new Employee("Fred", startDate, convert(LocalDate.of(2017, 6, 25)), tester, qa, 250000));

      employeeRepository.save(new Employee("Nikolas", startDate, admin, support, 650000));
      employeeRepository.save(new Employee("Toby", startDate, convert(LocalDate.of(2017, 4, 15)), admin, support, 650000));
    };
  }

  private static Date convert(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }
}
