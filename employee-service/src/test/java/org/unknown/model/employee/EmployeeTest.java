package org.unknown.model.employee;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.unknown.model.department.Department;
import org.unknown.model.position.Position;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: Artem Voronov
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeTest {

  @BeforeClass
  public static void setUp() {
    System.setProperty("unit.testing.enabled", "true");
  }

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private EmployeeRepository repository;

  @Test
  public void testSaveAndLoad() throws Exception {
    Department department  = this.entityManager.persist(new Department("Production"));
    Position position  = this.entityManager.persist(new Position("Software engineer"));
    Employee employee  = this.entityManager.persist(new Employee("Bob", new Date(), position, department, 300000));

    assertThat(employee.getId()).isNotNull();

    List<Employee> employees = this.repository.findByName("Bob");

    assertThat(employees.size()).isEqualTo(1);

    Employee loaded = employees.get(0);
    assertThat(loaded).isEqualToComparingFieldByField(employee);
  }
}
