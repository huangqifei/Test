package travel.struts.data;

public class TravelGroup {
	
	private int id;
	
	private String sight;
	
	private String name;
	
	private int cost;
	
	private int haspeople;
	
	private int maxpeople;
	
	private String info;
	
	private int reservepeople;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSight() {
		return sight;
	}

	public void setSight(String sight) {
		this.sight = sight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getReservepeople() {
		return reservepeople;
	}

	public void setReservepeople(int reservepeople) {
		this.reservepeople = reservepeople;
	}
	
}
