package org.unknown;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Artem Voronov
 */
@FeignClient("employee-service")
public interface EmployeeServiceClient {
  @RequestMapping("/employee")
  String employee();
}
