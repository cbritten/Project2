package dev.group.controllers;

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

import dev.group.beans.P2user;
import dev.group.services.P2userService;

@CrossOrigin
@RestController
public class P2userController {

	@Autowired
	P2userService us;
	
	@RequestMapping(value="/users", method=RequestMethod.POST, consumes="application/json")
	public P2user createP2user(@RequestBody P2user user) {
		return us.createP2user(user);
	}
	
	@GetMapping (value = "/users", produces="application/json")
	public List<P2user> allP2users(){
		return us.allP2users();
	}
	
	@GetMapping(value = "/users/search", produces="application/json")
	public P2user getP2usersByUsernameAndPword(@RequestParam String username,@RequestParam String pword){
		
		return us.getP2usersByUsernameAndPword(username,pword);
	}
	
	@GetMapping (value="/users/{userId}", produces="application/json")
	public P2user getP2userById(@PathVariable("userId") int userId) {
		return us.getUserById(userId);
	}
	
	@DeleteMapping(value="/users/{userId}")
	public boolean deleteP2user(@PathVariable("userId") int userId) {
		return us.deleteP2user(us.getUserById(userId));
	}

	@GetMapping(value="/calcurating/{userId}")
    public double userRating(@PathVariable("userId") int userId ) {
        return us.userRating(userId);  
    }
    
    @PutMapping(value="/users", consumes="application/json")
    public P2user updateUser(@RequestBody P2user change) {
        return us.updateP2user(change);
    }
	
}
