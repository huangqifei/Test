package travel.struts.actions;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Plane;
import travel.struts.datemanager.PlaneManager;

public class AdminPlaneModifyAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int planeId = Integer.parseInt(request.getParameter("id"));
		Plane plane = PlaneManager.getInstance().findPlaneById(planeId);
		request.setAttribute("plane", plane);
		return mapping.findForward("success");
	}
}
