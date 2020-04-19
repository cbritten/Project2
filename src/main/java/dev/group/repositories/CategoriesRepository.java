package dev.group.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.group.beans.Categories;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Integer> {

	Categories findCategoiesByReviewRevId(int revId);
}
