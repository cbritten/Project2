package dev.group.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.group.beans.Categories;
import dev.group.beans.Review;
import dev.group.repositories.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	CategoriesRepository cr;

	@Override
	public Categories addCategories(Categories categories) {
		return  cr.save(categories);
	}

	@Override
	public Categories getCategoriesById(int revId) {
		return cr.findById(revId).get();
	}

	@Override
	public List<Categories> getCategories() {
		return (List<Categories>)cr.findAll();
	}

	@Override
	public Categories updateCategories(Categories change) {
		return cr.save(change);
	}

	@Override
	public boolean deleteCategories(Categories delete) {
		try {
			cr.delete(delete);
			return true;
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Categories getCategoriesByRevId(int revId) {
		return cr.findCategoiesByReviewRevId(revId);
	}
	
}
