package travel.struts.actionforms;

import org.apache.struts.action.ActionForm;

public class DetailInfoActionForm extends ActionForm {
	private String tname;
	
	private String telephone;
	
	private String email;
	
	private String sightName;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
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

	public String getSightName() {
		return sightName;
	}

	public void setSightName(String sightName) {
		this.sightName = sightName;
	}
	
}
