package dev.group.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.group.beans.Comments;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer>{
	
	List<Comments> findByReviewRevId(@Param("rev_Id")int Review);
	
}
