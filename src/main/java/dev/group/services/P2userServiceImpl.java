package dev.group.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.group.beans.P2user;
import dev.group.beans.Review;
import dev.group.repositories.P2userRepository;

@Service
public class P2userServiceImpl implements P2userService {

	@Autowired
	P2userRepository ur;
	@Autowired
	ReviewServiceImpl rs;

	@Override
	public P2user createP2user(P2user user) {
		return ur.save(user);
	}

	@Override
	public P2user getUserById(int userId) {
		System.out.println("userId is:" + userId);
		int id = userId;
		return ur.findById(id).get();
	}

	@Override
	public List<P2user> allP2users() {
		return (List<P2user>) ur.findAll();
	}

	@Override
	public P2user getP2usersByUsernameAndPword(String username, String pword) {
		return ur.findByUsernameAndPword(username, pword);
	}

	@Override
	public P2user updateP2user(P2user change) {
		return ur.save(change);
	}

	@Override
	public boolean deleteP2user(P2user user) {
		try {
			ur.delete(user);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	public double userRating(int userid) {
        double urating=0;
        double sumup=0;
        double sumdown=0;
        List<Review> userreviews=rs.getReviewByUserId(userid);
        for(int i=0;i<userreviews.size();i++) {
            sumup+=userreviews.get(i).gettUp();
            sumdown+=userreviews.get(i).gettDown();
        }
        if(sumup==0 & sumdown==0) {
            urating=0;
        }else {
            urating=sumup/(sumup+sumdown);
        }
        
        return (double)Math.round(10*(urating*100))/100;
	}
        


}
