package dev.group.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Neighborhood {
	@Id
	@GeneratedValue
	@Column(name="neighb_id")
	private int neighbId;
	
	@Column(name="neighb_name")
	private String neighbName;
	
	@Column(name="neighb_rating")
	private int neighbRating;
	
	@Column(name="neighb_loc")
	private String neighbLoc;
	private int popsqm;
	private int avgprice;
	private int hospital;
	private int pow;
	private int education;
	private int grocery;
	private int transit;
	private int airports;
	private int hotels;
	private int pubsrv;
	private double crmrate;
	private double povrate;
	private double homrate;
	
	public Neighborhood() {
		super();
	}

	public Neighborhood(String neighbName, int neighbRating, String neighbLoc, int popsqm, int avgprice, int hospital,
			int pow, int education, int grocery, int transit, int airports, int hotels, int pubsrv, int crmrate,
			int povrate, int homrate) {
		super();
		this.neighbName = neighbName;
		this.neighbRating = neighbRating;
		this.neighbLoc = neighbLoc;
		this.popsqm = popsqm;
		this.avgprice = avgprice;
		this.hospital = hospital;
		this.pow = pow;
		this.education = education;
		this.grocery = grocery;
		this.transit = transit;
		this.airports = airports;
		this.hotels = hotels;
		this.pubsrv = pubsrv;
		this.crmrate = crmrate;
		this.povrate = povrate;
		this.homrate = homrate;
	}

	public Neighborhood(int neighbId, String neighbName, int neighbRating, String neighbLoc, int popsqm, int avgprice, int hospital,
			int pow, int education, int grocery, int transit, int airports, int hotels, int pubsrv, int crmrate,
			int povrate, int homrate) {
		super();
		this.neighbId = neighbId;
		this.neighbName = neighbName;
		this.neighbRating = neighbRating;
		this.neighbLoc = neighbLoc;
		this.popsqm = popsqm;
		this.avgprice = avgprice;
		this.hospital = hospital;
		this.pow = pow;
		this.education = education;
		this.grocery = grocery;
		this.transit = transit;
		this.airports = airports;
		this.hotels = hotels;
		this.pubsrv = pubsrv;
		this.crmrate = crmrate;
		this.povrate = povrate;
		this.homrate = homrate;
	}

	public int getNeighbId() {
		return neighbId;
	}

	public void setNeighbId(int neighbId) {
		this.neighbId = neighbId;
	}

	public String getNeighbName() {
		return neighbName;
	}

	public void setNeighbName(String neighbName) {
		this.neighbName = neighbName;
	}

	public int getNeighbRating() {
		return neighbRating;
	}

	public void setNeighbRating(int neighbRating) {
		this.neighbRating = neighbRating;
	}

	public String getNeighbLoc() {
		return neighbLoc;
	}

	public void setNeighbLoc(String neighbLoc) {
		this.neighbLoc = neighbLoc;
	}

	public int getPopsqm() {
		return popsqm;
	}

	public void setPopsqm(int popsqm) {
		this.popsqm = popsqm;
	}

	public int getAvgprice() {
		return avgprice;
	}

	public void setAvgprice(int avgprice) {
		this.avgprice = avgprice;
	}

	public int getHospital() {
		return hospital;
	}

	public void setHospital(int hospital) {
		this.hospital = hospital;
	}

	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

	public int geteducation() {
		return education;
	}

	public void seteducation(int education) {
		this.education = education;
	}

	public int getgrocery() {
		return grocery;
	}

	public void setgrocery(int grocery) {
		this.grocery = grocery;
	}

	public int getTransit() {
		return transit;
	}

	public void setTransit(int transit) {
		this.transit = transit;
	}

	public int getAirports() {
		return airports;
	}

	public void setAirports(int airports) {
		this.airports = airports;
	}

	public int getHotels() {
		return hotels;
	}

	public void setHotels(int hotels) {
		this.hotels = hotels;
	}

	public int getPubsrv() {
		return pubsrv;
	}

	public void setPubsrv(int pubsrv) {
		this.pubsrv = pubsrv;
	}

	public double getCrmrate() {
		return crmrate;
	}

	public void setCrmrate(int crmrate) {
		this.crmrate = crmrate;
	}

	public double getPovrate() {
		return povrate;
	}

	public void setPovrate(int povrate) {
		this.povrate = povrate;
	}

	public double getHomrate() {
		return homrate;
	}

	public void setHomrate(int homrate) {
		this.homrate = homrate;
	}

	@Override
	public String toString() {
		return "Neighborhood [neighbId=" + neighbId + ", neighbName=" + neighbName + ", neighbRating=" + neighbRating
				+ ", neighbLoc=" + neighbLoc + ", popsqm=" + popsqm + ", avgprice=" + avgprice + ", hospital="
				+ hospital + ", pow=" + pow + ", education=" + education + ", grocery=" + grocery + ", transit="
				+ transit + ", airports=" + airports + ", hotels=" + hotels + ", pubsrv=" + pubsrv + ", crmrate="
				+ crmrate + ", povrate=" + povrate + ", homrate=" + homrate + "]";
	}
	
}