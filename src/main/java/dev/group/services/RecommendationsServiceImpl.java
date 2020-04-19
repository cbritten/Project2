package dev.group.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.group.beans.Recommendations;
import dev.group.repositories.RecommendationsRepository;

@Service
public class RecommendationsServiceImpl implements RecommendationsService{
	
	@Autowired
	RecommendationsRepository rr; 

	@Override
	public Recommendations createRecommendation(Recommendations rec) {
		return rr.save(rec);
	}

	@Override
	public List<Recommendations> getAllRecommendations() {
		return (List<Recommendations>)rr.findAll(); 
	}
}
