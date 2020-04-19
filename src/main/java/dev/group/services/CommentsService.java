package dev.group.services;

import java.util.List;

import dev.group.beans.Comments;

public interface CommentsService {

	public Comments createComment(Comments cmnt); 
	public List<Comments> getAllCommentsById(int Review); 
}
