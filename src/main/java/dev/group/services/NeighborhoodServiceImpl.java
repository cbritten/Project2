package dev.group.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.group.beans.Neighborhood;
import dev.group.repositories.NeighborhoodRepository;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

	@Autowired
	NeighborhoodRepository nr;
	
	@Override
	public Neighborhood createNeighborhood(Neighborhood neighborhood) {
		return nr.save(neighborhood);
	}

	@Override
	public Neighborhood getNeighborhoodById(int neighbId) {
		System.out.println("what is neighbId: " + neighbId);
		return nr.findById(neighbId).get();
	}

	@Override
	public List<Neighborhood> allNeighborhoods(Neighborhood neighborhood) {
		return (List<Neighborhood>)nr.findAll();
	}

	@Override
	public List<Neighborhood> getNeighborhoodsbyName(String neighbName) {
		return nr.findByNeighbName(neighbName);
	}

	@Override
	public Neighborhood updateNeighborhood(Neighborhood change) {
		return nr.save(change);
	}

	@Override
	public boolean deleteNeighborhood(Neighborhood neighborhood) {
		try {
			nr.delete(neighborhood);
			return true;
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}

