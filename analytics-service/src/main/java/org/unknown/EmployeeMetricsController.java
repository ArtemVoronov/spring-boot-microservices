package org.unknown;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unknown.model.Employee;
import org.unknown.model.EmployeeList;
import org.unknown.model.EmployeeMetrics;


/**
 * Author: Artem Voronov
 */
@EnableFeignClients
@RestController
public class EmployeeMetricsController {

  private static final ObjectMapper MAPPER = new ObjectMapper();
  static {
    MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Autowired
  private EmployeeServiceClient employeeServiceClient;

  //TODO
  @RequestMapping("/employee-metrics")
  public String getEmployeeMetrics() {
    try {
      String json = employeeServiceClient.employee();
      JsonNode rootNode = MAPPER.readValue(json, JsonNode.class);
      if (!rootNode.has("_embedded"))
        throw new IllegalStateException("missed '_embedded' field!");

      JsonNode embedded = rootNode.get("_embedded");
      final EmployeeList employeeList = MAPPER.readValue(embedded.toString(), EmployeeList.class);

      EmployeeMetrics result = new EmployeeMetrics();
      result.setCount(employeeList.size());
      result.setAverageSalary(employeeList.getEmployee().stream().mapToInt(Employee::getSalary).average().getAsDouble());

      return MAPPER.writeValueAsString(result);
//      return result;
    } catch (Exception e) {
      return "TODO: error handling";
    }
  }
}
