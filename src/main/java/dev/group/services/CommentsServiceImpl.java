package dev.group.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.group.beans.Comments;
import dev.group.repositories.CommentsRepository;
import dev.group.repositories.ReviewRepository;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	CommentsRepository cr; 
	@Autowired
	ReviewService rr; 
	
	@Override
	public Comments createComment(Comments cmnt) {
		return cr.save(cmnt); 
	}

	@Override
	public List<Comments> getAllCommentsById(int Review) {
		return (List<Comments>)cr.findByReviewRevId(Review); 
	}

	
}
