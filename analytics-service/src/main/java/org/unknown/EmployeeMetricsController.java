package org.unknown;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unknown.converters.LocalDateDeserializer;
import org.unknown.model.Employee;
import org.unknown.model.EmployeeMetrics;
import org.unknown.model.Response;

import java.io.IOException;
import java.time.*;
import java.util.List;


/**
 * Author: Artem Voronov
 */
@EnableFeignClients
@RestController
public class EmployeeMetricsController {

  private static final ObjectMapper MAPPER = new ObjectMapper();
  static {
    JavaTimeModule javaTimeModule = new JavaTimeModule();
    javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
    MAPPER.registerModule(javaTimeModule);
    MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Autowired
  private EmployeeServiceClient employeeServiceClient;

  @RequestMapping("/employee-metrics")
  public EmployeeMetrics getEmployeeMetrics() throws IOException {
    String json = employeeServiceClient.employee();
    Response response = MAPPER.readValue(json, Response.class);
    List<Employee> employees = response.getEmployees();

    EmployeeMetrics result = new EmployeeMetrics();

    if (employees == null || employees.isEmpty())
      return result;

    double averageSalary = employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();
    double averageWorkTimeInDays = employees.stream()
        .map(employee -> Period.between(employee.getEmploymentDate(), employee.getDismissalDate() == null ? LocalDate.now() : employee.getDismissalDate()))
        .mapToInt(period -> period.getDays())
        .average().getAsDouble();

    result.setEmployeeQuantity(employees.size());
    result.setAverageSalaryInCents(averageSalary);
    result.setAverageWorkTimeInDays(averageWorkTimeInDays);

    return result;
  }
}
