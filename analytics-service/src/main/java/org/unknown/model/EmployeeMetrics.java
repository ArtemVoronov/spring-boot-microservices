package org.unknown.model;

/**
 * Author: Artem Voronov
 */
public class EmployeeMetrics {

  private int employeeQuantity;
  private double averageSalaryInCents;
  private double averageWorkTimeInDays;

  public int getEmployeeQuantity() {
    return employeeQuantity;
  }

  public void setEmployeeQuantity(int employeeQuantity) {
    this.employeeQuantity = employeeQuantity;
  }

  public double getAverageSalaryInCents() {
    return averageSalaryInCents;
  }

  public void setAverageSalaryInCents(double averageSalaryInCents) {
    this.averageSalaryInCents = averageSalaryInCents;
  }

  public double getAverageWorkTimeInDays() {
    return averageWorkTimeInDays;
  }

  public void setAverageWorkTimeInDays(double averageWorkTimeInDays) {
    this.averageWorkTimeInDays = averageWorkTimeInDays;
  }
}
