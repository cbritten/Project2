package dev.group.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.group.beans.Neighborhood;
import dev.group.beans.Recommendations;

@Repository
public interface RecommendationsRepository extends CrudRepository<Recommendations, Integer> {

}
