package dev.group.services;

import java.util.List;

import dev.group.beans.Review;

public interface ReviewService {

	public Review addReview(Review review);
	public List<Review> getSingleReview(int neighbId, int userId);

	public List<Review> allReviews(int neighbId, int userId);
	public Review getReviewById(int revId);
	public List<Review> getAllReviews();
	public Review updateReview(Review change);
	public boolean deleteReview(Review delete);
	public List<Review> getReviewByNeighbId(int neighbId);
	public List<Review> getReviewByUserId(int userId);
	
}
