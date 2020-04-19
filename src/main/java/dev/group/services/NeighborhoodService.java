package dev.group.services;

import java.util.List;

import dev.group.beans.Neighborhood;

public interface NeighborhoodService {

	public Neighborhood createNeighborhood(Neighborhood neighborhood);
	
	public Neighborhood getNeighborhoodById(int neighbId);

	public List<Neighborhood> allNeighborhoods(Neighborhood neighborhood);
	
	public List<Neighborhood> getNeighborhoodsbyName(String neighbName);
	
	public Neighborhood updateNeighborhood(Neighborhood change);

	public boolean deleteNeighborhood(Neighborhood neighborhood);
}