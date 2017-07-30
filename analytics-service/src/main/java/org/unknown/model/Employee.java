package org.unknown.model;

import java.util.Date;

/**
 * Author: Artem Voronov
 */
public class Employee {

  private String name;

  private Date employmentDate;

  private Date dismissalDate;

  private Position position;

  private Department department;

  private Integer salary; // in cents

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getEmploymentDate() {
    return employmentDate;
  }

  public void setEmploymentDate(Date employmentDate) {
    this.employmentDate = employmentDate;
  }

  public Date getDismissalDate() {
    return dismissalDate;
  }

  public void setDismissalDate(Date dismissalDate) {
    this.dismissalDate = dismissalDate;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

}
