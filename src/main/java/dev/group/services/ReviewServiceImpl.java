package dev.group.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import dev.group.beans.Neighborhood;
import dev.group.beans.P2user;
import dev.group.beans.Review;
import dev.group.repositories.ReviewRepository;

@Service 
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository rr;
	@Autowired
	NeighborhoodService ns;
	@Autowired
	P2userService ps;
	
	
	@Override
	public Review getReviewById(int revId) {
		return rr.findById(revId).get();
	}
	
	@Override
	public Review addReview(Review review) {
		System.out.println("review at this point: " + review);
		return rr.save(review);
	}

	@Override
	public List<Review> getSingleReview(int neighbId, int userId) {
		return rr.findByNeighbNeighbIdAndUserUserId(neighbId, userId);
	}

	@Override
    public List<Review> getAllReviews() {
    return (List<Review>)rr.findAll();
    
    }
	
	@Override
	public List<Review> allReviews(int neighbId ,int userId) {
		List<Review> rList =new ArrayList<Review>();
		rr.findByUserUserId(userId).forEach(rList::add);
		rr.findByNeighbNeighbId(neighbId).forEach(rList::add);
		return rList;
	}
	
	@Override
	public Review updateReview(Review change) {

		return rr.save(change);
	}

	@Override
	public boolean deleteReview(Review delete) {
		
		try {
			rr.delete(delete);
			return true;
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Review> getReviewByNeighbId(@Param("neighbId")int neighbId){
		List<Review> rList =new ArrayList<Review>();
		rr.findByNeighbNeighbId(neighbId).forEach(rList::add);
		return rList;

	}
	
	@Override
	public List<Review> getReviewByUserId(int userId) {
		List<Review> rList =new ArrayList<Review>();
		rr.findByUserUserId(userId).forEach(rList::add);
		return rList;
	}
	
	
}
