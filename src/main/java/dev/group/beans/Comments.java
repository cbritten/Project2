package dev.group.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comments {
	

	@Id
	@GeneratedValue
	@Column(name = "cmnt_id")
	private int cmntId; 
	
	@ManyToOne
	@JoinColumn(name = "rev_id")
	private Review review;
	
	@Column(name = "cmnt") 
	String cmnt;

	public Comments() {
		super();
	}

	public Comments(Review review, String cmnt) {
		super();
		this.review = review;
		this.cmnt = cmnt;
	}

	public Comments(String cmnt) {
		super();
		this.review = new Review(); 
		this.cmnt = cmnt;
	}

	public int getCmntId() {
		return cmntId;
	}

	public void setCmntId(int cmntId) {
		this.cmntId = cmntId;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}

	@Override
	public String toString() {
		return "Comments [cmntId=" + cmntId + ", review=" + review + ", cmnt=" + cmnt + "]";
	}

	
}
