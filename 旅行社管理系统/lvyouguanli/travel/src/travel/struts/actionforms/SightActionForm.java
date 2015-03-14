package travel.struts.actionforms;

import org.apache.struts.action.ActionForm;

public class SightActionForm extends ActionForm {
	
	private String name;
	
	private String city;
	
	private int ticket_cost;
	
	private int discount;
	
	private String info;
	
	private int reservepeople;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getReservepeople() {
		return reservepeople;
	}

	public void setReservepeople(int reservepeople) {
		this.reservepeople = reservepeople;
	}

	public int getTicket_cost() {
		return ticket_cost;
	}

	public void setTicket_cost(int ticket_cost) {
		this.ticket_cost = ticket_cost;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
