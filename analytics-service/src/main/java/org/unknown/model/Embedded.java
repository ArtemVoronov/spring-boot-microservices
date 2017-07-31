package org.unknown.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Artem Voronov
 */
public class Embedded {
  @JsonProperty("employee")
  private List<Employee> employees = new ArrayList<>();

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
}
