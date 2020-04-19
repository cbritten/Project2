package dev.group.services;

import java.util.List;

import dev.group.beans.P2user;

public interface P2userService {

	public P2user createP2user(P2user user);
	
	public P2user getUserById(int userId);
	
	public List<P2user> allP2users();
	
	public P2user getP2usersByUsernameAndPword(String username, String pword);
	
	public P2user updateP2user(P2user change);
	
	public boolean deleteP2user(P2user user);
	
	public double userRating(int userid); 
}
