package org.unknown.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Author: Artem Voronov
 */
public class Response {
  @JsonProperty("_embedded")
  private Embedded embedded;

  public Embedded getEmbedded() {
    return embedded;
  }

  public void setEmbedded(Embedded embedded) {
    this.embedded = embedded;
  }

  @JsonIgnore
  public List<Employee> getEmployees() {
    return embedded.getEmployees();
  }
}
