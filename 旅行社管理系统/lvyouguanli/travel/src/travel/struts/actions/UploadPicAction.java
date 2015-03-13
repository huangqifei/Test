package travel.struts.actions;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import travel.struts.actionforms.UploadPicActionForm;

public class UploadPicAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadPicActionForm upaf = (UploadPicActionForm)form;
		FormFile file = upaf.getFile();
		if(file != null) {
			FileOutputStream fos = new FileOutputStream("travel/WebRoot/img/" + file.getFileName());
			fos.write(file.getFileData());
			fos.flush();
			fos.close();
		}
		return super.execute(mapping, form, request, response);
	}
}
