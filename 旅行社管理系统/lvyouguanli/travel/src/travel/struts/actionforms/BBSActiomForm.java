package travel.struts.actionforms;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

public class BBSActiomForm extends ActionForm {
	private String name;
	
	private String content;
	
	private Date date;
	
	private int access;
	
	private int reply;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
