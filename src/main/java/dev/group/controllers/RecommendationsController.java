package dev.group.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.group.beans.Recommendations;
import dev.group.services.RecommendationsService;

@CrossOrigin
@RestController
public class RecommendationsController {
	
	@Autowired
	RecommendationsService rs; 
	
	@RequestMapping(value="/recommendations", method = RequestMethod.POST, consumes = "application/json")
	public Recommendations createRecommendations(@RequestBody Recommendations rec) {
		return rs.createRecommendation(rec); 
	}
	
	@GetMapping(value = "/recommendations")
	public List<Recommendations> getAllRecommendations(){
		return rs.getAllRecommendations(); 
	}

}
