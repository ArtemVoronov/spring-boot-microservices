package org.unknown.model.position;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Author: Artem Voronov
 */
@RepositoryRestResource(collectionResourceRel = "position", path = "position")
public interface PositionRepository extends CrudRepository<Position, Integer> {

  List<Position> findByName(String name);
}
