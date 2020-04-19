package dev.group.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recommendations {
	
	@Id
	@GeneratedValue
	@Column(name = "rec_id")
	int recId;
	@Column(name = "neighb_name")
	String neighb_name; 
	
	@Column(name = "neighb_loc")
	String neighb_loc;

	public Recommendations() {
		super();
	}

	public Recommendations(String neighb_name, String neighb_loc) {
		super();
		this.neighb_name = neighb_name;
		this.neighb_loc = neighb_loc;
	}

	public String getNeighb_name() {
		return neighb_name;
	}

	public void setNeighb_name(String neighb_name) {
		this.neighb_name = neighb_name;
	}

	public String getNeighb_loc() {
		return neighb_loc;
	}

	public void setNeighb_loc(String neighb_loc) {
		this.neighb_loc = neighb_loc;
	}

	@Override
	public String toString() {
		return "Recommendations [neighb_name=" + neighb_name + ", neighb_loc=" + neighb_loc + "]";
	} 

	
}
