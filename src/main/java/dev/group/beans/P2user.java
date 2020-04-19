package dev.group.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class P2user {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	private String roleof;
	private String username;
	private String pword;
	private String email;
	private String fname;
	private String lname;
	private String neighborhood;
	private double rating;
	private int allowemail;
	
////	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name="user_id")
//	private List<Review> reviews;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "p2user")
//	private List<Review> reviews = new ArrayList<Review>();
//	
	public P2user() {
		super();
	}

	public P2user(String roleof, String username, String password, String email, String fname, String lname,
			String neighborhood, double rating, int allowemail) {
		super();
		this.roleof = roleof;
		this.username = username;
		this.pword = password;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.neighborhood = neighborhood;
		this.rating = rating;
		this.allowemail = allowemail;
	//	this.reviews = new ArrayList();
	}
	
	public P2user(int userId, String roleof, String username, String password, String email, String fname, String lname,
			String neighborhood, double rating, int allowemail) {
		super();
		this.userId = userId;
		this.roleof = roleof;
		this.username = username;
		this.pword = password;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.neighborhood = neighborhood;
		this.rating = rating;
		this.allowemail = allowemail;
		//this.reviews = reviews;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getroleof() {
		return roleof;
	}

	public void setroleof(String roleof) {
		this.roleof = roleof;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String password) {
		this.pword = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getAllowemail() {
		return allowemail;
	}

	public void setAllowemail(int allowemail) {
		this.allowemail = allowemail;
	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + ", roleof=" + roleof + ", username=" + username + ", password=" + pword
				+ ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", neighborhood=" + neighborhood
				+ ", rating=" + rating + ", allowemail=" + allowemail + "]";
	}
}
