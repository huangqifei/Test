package travel.struts.data;

import java.util.Date;

public class Plane {
	
	private int id;
	
	private String number;
	
	private String fromcity;
	
	private String destination;
	
	private String fly_time;
	
	private String arrive_time;
	
	private String fly_type;
	
	private int haspeople;
	
	private int maxpeople;
	
	private int fee;
	
	private int reservedPeople;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFromcity() {
		return fromcity;
	}

	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFly_time() {
		return fly_time;
	}

	public void setFly_time(String fly_time) {
		this.fly_time = fly_time;
	}

	public String getArrive_time() {
		return arrive_time;
	}

	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}

	public int getFee() {
		return fee;
	}

	public String getFly_type() {
		return fly_type;
	}

	public void setFly_type(String fly_type) {
		this.fly_type = fly_type;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getHaspeople() {
		return haspeople;
	}

	public void setHaspeople(int haspeople) {
		this.haspeople = haspeople;
	}

	public int getMaxpeople() {
		return maxpeople;
	}

	public void setMaxpeople(int maxpeople) {
		this.maxpeople = maxpeople;
	}

	public int getReservedPeople() {
		return reservedPeople;
	}

	public void setReservedPeople(int reservedPeople) {
		this.reservedPeople = reservedPeople;
	}

}
