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

import dev.group.beans.Neighborhood;
import dev.group.services.NeighborhoodService;

@CrossOrigin
@RestController
public class NeighborhoodController {
	@Autowired
	NeighborhoodService ns;
	
	//*********************************************************
	//no update method 

	
	@RequestMapping(value="/neighborhoods", method=RequestMethod.POST, consumes="application/json")
	public Neighborhood createNeighb(@RequestBody Neighborhood neighborhood) {
		return ns.createNeighborhood(neighborhood);
	}
	
	@GetMapping (value = "/neighborhoods")
	public List<Neighborhood> allNeighborhoods(Neighborhood neighborhood){
		return ns.allNeighborhoods(neighborhood);
	}
	@GetMapping(value = "/neighborhoods/search")
	public List<Neighborhood> getUserByNeighbName(@RequestParam String neighbName){
		return ns.getNeighborhoodsbyName(neighbName);
	}
	@GetMapping (value="/neighborhoods/{neighbId}")
	public Neighborhood getNeighborhoodById(@PathVariable("neighbId") int neighbId) {
		return ns.getNeighborhoodById(neighbId);
	}
	
    @PutMapping(value="/neighborhoods", consumes="application/json")
    public Neighborhood updateNeighb(@RequestBody Neighborhood change) {
        return ns.updateNeighborhood(change);
    }
	@DeleteMapping(value="/neighborhoods/{neighbId}")
	public boolean deleteNeighborhood(@PathVariable("neighbId") int neighbId) {
		return ns.deleteNeighborhood(ns.getNeighborhoodById(neighbId));
	}
}

