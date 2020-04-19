package dev.group.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.group.beans.Comments;
import dev.group.repositories.CommentsRepository;
import dev.group.services.CommentsService;
import dev.group.services.ReviewService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentsController {
	
	@Autowired
	CommentsService cs; 
	@Autowired
	ReviewService rs; 
	
	@RequestMapping(value = "/comments/{revId}", method = RequestMethod.POST, consumes = "application/json")
	public Comments createComment(@RequestBody Comments cmnt, @PathVariable int revId) {	
		cmnt.setReview(rs.getReviewById(revId));
		return cs.createComment(cmnt); 
	}
	
	@GetMapping(value = "/comments/{revId}", produces = "application/json")
	public List<Comments> getAllCommentsById(@PathVariable ("revId") int revId){
		return cs.getAllCommentsById(revId);  
	}

}
