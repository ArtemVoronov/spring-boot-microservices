package org.unknown.model.department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Author: Artem Voronov
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartmentTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private DepartmentRepository repository;

  @Test
  public void testSaveAndLoad() throws Exception {
    Department department  = this.entityManager.persist(new Department("Production"));

    assertThat(department.getId()).isNotNull();

    List<Department> departments = this.repository.findByName("Production");

    assertThat(departments.size()).isEqualTo(1);

    Department loaded = departments.get(0);
    assertThat(loaded).isEqualToComparingFieldByField(department);
  }

}
