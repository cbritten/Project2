package dev.group.services;

import java.util.List;

import dev.group.beans.Recommendations;

public interface RecommendationsService {

	public Recommendations createRecommendation(Recommendations rec); 
	public List<Recommendations> getAllRecommendations(); 
	
}
