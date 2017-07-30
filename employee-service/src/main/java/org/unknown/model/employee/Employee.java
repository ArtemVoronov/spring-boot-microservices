package org.unknown.model.employee;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.unknown.model.department.Department;
import org.unknown.model.position.Position;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Author: Artem Voronov
 */
@Entity(name="employee")
@Table(name="employees")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false, length = 150)
  @NotNull(message = "Employee name is null")
  @NotEmpty(message = "Employee name is empty")
  private String name;

  @Column(name="employment_date", nullable = false)
  @NotNull(message = "Employment date is null")
  private Date employmentDate;

  @Column(name="dismissal_date")
  private Date dismissalDate;

  @CreationTimestamp
  @Column(name="create_date")
  private Date createDate;

  @OneToOne
  @JoinColumn (name = "position_id", nullable = false)
  private Position position;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "department_id")
  @NotNull(message = "Employee department can't be null")
  private Department department;

  @Column(name="salary", nullable = false)
  private Integer salary; // in cents

  protected Employee() {
  }

  public Employee(String name, Date employmentDate, Position position, Department department, Integer salary) {
    this.name = name;
    this.employmentDate = employmentDate;
    this.position = position;
    this.department = department;
    this.salary = salary;
  }

  public Employee(String name, Date employmentDate, Date dismissalDate, Position position, Department department, Integer salary) {
    this.name = name;
    this.employmentDate = employmentDate;
    this.dismissalDate = dismissalDate;
    this.position = position;
    this.department = department;
    this.salary = salary;
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

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
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

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", position=" + position.getName() +
        ", department=" + department.getName() +
        '}';
  }
}
