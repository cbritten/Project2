package dev.group.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.group.beans.Review;
import dev.group.services.NeighborhoodService;
import dev.group.services.P2userService;
import dev.group.services.ReviewService;
@CrossOrigin
@RestController
public class ReviewController {
    @Autowired
    ReviewService rs;
    @Autowired
    NeighborhoodService ns;
    @Autowired
    P2userService us;
    
    @RequestMapping(value="/reviews/{neighbId}/{userId}", method=RequestMethod.POST, consumes ="application/json")
    public Review addReview(@RequestBody Review review, @PathVariable  int neighbId,
            @PathVariable int userId) {
        
        review.setNeighb(ns.getNeighborhoodById(neighbId));
        review.setUser(us.getUserById(userId));
        
        return rs.addReview(review); 
    }
     
    @GetMapping(value="/reviews/{neighbId}/{userId}", produces="application/json")
    public List<Review> getSingleReview(@PathVariable("neighbId") int neighbId, 
            @PathVariable("userId")  int userId){ 
        return rs.getSingleReview(neighbId, userId );
    }
    
    @GetMapping(value="/reviews/{neighbId}", produces="application/json")
    public List<Review> getReviewByNeighbId(@PathVariable("neighbId") int neighbId){    
        return rs.getReviewByNeighbId(neighbId);
    }
    @GetMapping(value="/reviews/search",  produces="application/json")
    public List<Review> getReviews(@RequestParam(required=false) Integer neighbId,
            @RequestParam(required=false) Integer userId){
        if(neighbId != null && userId != null) {
            return rs.getSingleReview(userId, neighbId);
        }
        else if(neighbId != null) {
            return rs.getReviewByNeighbId(neighbId);
        }else if (userId != null) {
            return rs.getReviewByUserId(userId);
        }else {
            return new ArrayList<Review>();
        }
    }
    
    @GetMapping(value="/reviews", produces="application/json")
    public List<Review> getReviews(){
        return rs.getAllReviews();
    }
    
    @GetMapping (value="/getreviewbyid/{revId}", produces="application/json")
    public Review getReviewById(@PathVariable int revId) {
        return rs.getReviewById(revId);
    }
    
    @PutMapping(value="/reviews", consumes="application/json")
    public Review updateReview(@RequestBody Review change) {
        Review temp=rs.getReviewById(change.getRevId());
        change.setNeighb(temp.getNeighb());
        change.setUser(temp.getUser());
        return rs.updateReview(change);
    }
    
    @DeleteMapping(value="/reviews/{revId}")
    public boolean deleteReview(@PathVariable int revId) {
        return rs.deleteReview(rs.getReviewById(revId));
    }
    
}