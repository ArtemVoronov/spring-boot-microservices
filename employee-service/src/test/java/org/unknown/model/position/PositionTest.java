package org.unknown.model.position;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author: Artem Voronov
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PositionTest {

  @BeforeClass
  public static void setUp() {
    System.setProperty("unit.testing.enabled", "true");
  }

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private PositionRepository repository;

  @Test
  public void testSaveAndLoad() throws Exception {
    Position position  = this.entityManager.persist(new Position("Software engineer"));

    assertThat(position.getId()).isNotNull();

    List<Position> positions = this.repository.findByName("Software engineer");

    assertThat(positions.size()).isEqualTo(1);

    Position loaded = positions.get(0);
    assertThat(loaded).isEqualToComparingFieldByField(position);
  }
}
