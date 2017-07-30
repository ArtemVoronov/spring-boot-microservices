package org.unknown.model.department;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Author: Artem Voronov
 */
@RepositoryRestResource(collectionResourceRel = "department", path = "department")
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

  List<Department> findByName(String name);
}
