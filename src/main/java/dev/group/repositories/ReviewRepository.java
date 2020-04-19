package dev.group.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.group.beans.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

	List<Review> findByNeighbNeighbIdAndUserUserId(@Param("neighb_Id")int neighb, @Param("User_Id")int user);
	List<Review> findByNeighbNeighbId(@Param("neighb_Id")int neighb);
	List<Review> findByUserUserId(@Param("User_Id")int user);
	 
}
