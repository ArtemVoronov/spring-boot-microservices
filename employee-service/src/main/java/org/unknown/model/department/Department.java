package org.unknown.model.department;

import org.hibernate.validator.constraints.NotEmpty;
import org.unknown.model.employee.Employee;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Artem Voronov
 */
@Entity(name="department")
@Table(name="departments")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false, length = 300)
  @NotNull(message = "Department name is null")
  @NotEmpty(message = "Department name is empty")
  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = {CascadeType.PERSIST})
  private List<Employee> employees = new ArrayList<>();

  protected Department() {}

  public Department(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return "Department{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
