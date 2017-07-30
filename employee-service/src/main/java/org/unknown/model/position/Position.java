package org.unknown.model.position;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Author: Artem Voronov
 */
@Entity(name="position")
@Table(name="positions")
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false, length = 300)
  @NotNull(message = "Position name is null")
  @NotEmpty(message = "Position name is empty")
  private String name;

  protected Position() {
  }

  public Position(String name) {
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

  @Override
  public String toString() {
    return "Position{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
