package dev.group.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.group.beans.Neighborhood;

@Repository
public interface NeighborhoodRepository extends CrudRepository<Neighborhood, Integer> {
	List<Neighborhood> findByNeighbName(String neighbName);
}
