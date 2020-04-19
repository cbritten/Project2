package dev.group.services;

import java.util.List;

import dev.group.beans.Categories;

public interface CategoriesService {

	public Categories addCategories(Categories categories);
	public Categories getCategoriesByRevId(int revId);
	public Categories getCategoriesById(int catId);
	public List<Categories> getCategories();
	public Categories updateCategories(Categories change);
	public boolean deleteCategories(Categories delete);
}
