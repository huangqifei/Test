package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.datemanager.PlaneManager;
import travel.struts.datemanager.SightManager;

public class AdminPlaneDeleteAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int planeId = Integer.parseInt(request.getParameter("id"));
		PlaneManager.getInstance().deletePlaneById(planeId);
		return mapping.findForward("success");
	}
}
