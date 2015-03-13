package travel.struts.data;

public class DetailInfo {
	private String name;
	
	private String tname;
	
	private String telephone;
	
	private String email;

	public String getName() {
		return name;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telphone) {
		this.telephone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
