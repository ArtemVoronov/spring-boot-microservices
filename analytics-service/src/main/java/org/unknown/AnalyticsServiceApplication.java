package org.unknown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class AnalyticsServiceApplication {

  @Autowired
  private GreetingClient greetingClient;

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsServiceApplication.class, args);
	}

  //TODO clean
  @RequestMapping("/get-greeting")
  public String greeting() {
    return greetingClient.greeting();
  }

  @FeignClient("employee-service")
  public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();
  }
}
