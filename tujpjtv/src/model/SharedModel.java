package model;

public class SharedModel {
	private String shipnum;
	private String type;
	private String date;
	private String origin;
	private String destination;
	private String numofseats;


	public String getShipnum() {
		return shipnum;
	}
	public void setShipnum(String shipnum) {
		this.shipnum = shipnum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	private String orderid;

	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	public String getNumofseats() {
		return numofseats;
	}
	public void setNumofseats(String numofseats) {
		this.numofseats = numofseats;
	}
	
}
