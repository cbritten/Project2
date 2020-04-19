package dev.group.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Review {

	@Id
	@GeneratedValue
	@Column(name="rev_id")
	private int revId;
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private P2user user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="neighb_Id", nullable=false)
	private Neighborhood neighb;
	
	private String dateOf;
	
	private int tUp;
	
	private int tDown;
	
	private String info;
	


	public Review() {
		super();
	}

	public Review(int revId, P2user user, Neighborhood neighb, int tUp, int tDown, String info) {
		super();
		this.revId = revId;
		this.user = user;
		this.neighb = neighb;
		this.tUp = tUp;
		this.tDown = tDown;
		this.info = info;
	}

	public Review(String dateOf, int tUp, int tDown, String info) {
		super();
		this.tUp = tUp;
		this.tDown = tDown;
		this.info = info;
		this.user =new P2user();
		this.neighb=new Neighborhood();
	}
	
	public int getRevId() {
		return revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public int gettUp() {
		return tUp;
	}

	public void settUp(int tUp) {
		this.tUp = tUp;
	}

	public int gettDown() {
		return tDown;
	}

	public void settDown(int tDown) {
		this.tDown = tDown;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	public P2user getUser() {
		return user;
	}

	public void setUser(P2user user) {
		this.user = user;
	}

	public Neighborhood getNeighb() {
		return neighb;
	}

	public void setNeighb(Neighborhood neighb) {
		this.neighb = neighb;
	}

	public String getDateOf() {
		return dateOf;
	}

	public void setDateOf(String dateOf) {
		this.dateOf = dateOf;
	}

	@Override
	public String toString() {
		return "Review [revId=" + revId + ", user=" + user + ", neighb=" + neighb + ", dateOf=" + dateOf + ", tUp="
				+ tUp + ", tDown=" + tDown + ", info=" + info + "]";
	}


}
