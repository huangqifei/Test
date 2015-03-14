package travel.struts.actionforms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadPicActionForm extends ActionForm {
	
	private String fileName;
	
	private FormFile file;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}
	
}
