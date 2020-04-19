package dev.group.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Categories {

	@Id
	@GeneratedValue
	private int catId;
	
	private double cleanliness;
	private double qLife;
	private double safety;
	private double ammentities;
	private double essentials;
	
	@OneToOne
	@JoinColumn(name="rev_id")
	private Review review;
	
	public Categories() {
		super();
	}

	public Categories(double cleanliness, double qLife, double safety, double ammentities, double essentials) {
		super();
		this.cleanliness = cleanliness;
		this.qLife = qLife;
		this.safety = safety;
		this.ammentities = ammentities;
		this.essentials = essentials;
	}

	public Categories(int catId, double cleanliness, double qLife, double safety, double ammentities, double essentials) {
		super();
		this.catId = catId;
		this.cleanliness = cleanliness;
		this.qLife = qLife;
		this.safety = safety;
		this.ammentities = ammentities;
		this.essentials = essentials;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public double getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(double cleanliness) {
		this.cleanliness = cleanliness;
	}

	public double getqLife() {
		return qLife;
	}

	public void setqLife(double qLife) {
		this.qLife = qLife;
	}

	public double getSafety() {
		return safety;
	}

	public void setSafety(double safety) {
		this.safety = safety;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
	public double getAmmentities() {
		return ammentities;
	}

	public void setAmmentities(double ammentities) {
		this.ammentities = ammentities;
	}

	public double getEssentials() {
		return essentials;
	}

	public void setEssentials(double essentials) {
		this.essentials = essentials;
	}

	@Override
	public String toString() {
		return "Categories [catId=" + catId + ", cleanliness=" + cleanliness + ", qLife=" + qLife + ", safety=" + safety
				+ ", ammentities=" + ammentities + ", essentials=" + essentials + ", review=" + review + "]";
	}
	
	
}
