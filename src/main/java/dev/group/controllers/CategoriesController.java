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

import dev.group.beans.Categories;
import dev.group.beans.Review;
import dev.group.services.CategoriesService;
import dev.group.services.ReviewService;

@CrossOrigin
@RestController
public class CategoriesController {

	@Autowired
	CategoriesService cs;
	@Autowired
	ReviewService rs;
	
	//*********************************************************
	// all working


	
	@RequestMapping(value="/categories/{reviewId}", method=RequestMethod.POST, consumes="application/json")
	public Categories addCategories(@RequestBody Categories categories, @PathVariable int reviewId) {
		categories.setReview(rs.getReviewById(reviewId));
		
		return cs.addCategories(categories);
	}
	
	@GetMapping(value="/categories", produces="application/json")
	public List<Categories> allCategories(){
		return cs.getCategories();
	}
	
	@GetMapping(value="/categories/{revId}", produces="application/json")
	public Categories getCategoriesByRevId(@PathVariable int revId) {
		return cs.getCategoriesById(revId);
	}
	
	@PutMapping(value="/categories", consumes="application/json")
	public Categories updateCategories(@RequestBody Categories change) {
		Categories temp=cs.getCategoriesById(change.getCatId());
		change.setReview(temp.getReview());
		return cs.updateCategories(change);
	}
	
	@DeleteMapping(value="/categories/{revId}")
	public boolean deleteCategories(@PathVariable int revId) {
		return cs.deleteCategories(cs.getCategoriesById(revId));
	}
}
