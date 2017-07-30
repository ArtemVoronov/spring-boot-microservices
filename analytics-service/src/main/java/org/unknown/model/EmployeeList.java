package org.unknown.model;

import java.util.List;

/**
 * Author: Artem Voronov
 */
public class EmployeeList {

  private List<Employee> employee;

  public List<Employee> getEmployee() {
    return employee;
  }

  public void setEmployee(List<Employee> employee) {
    this.employee = employee;
  }

  public int size() {
    if (employee == null)
      return 0;

    return employee.size();
  }
}
