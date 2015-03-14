package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Plane;
import travel.struts.datemanager.PlaneManager;

public class ModifyPlaneEnsureAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int planeId = Integer.parseInt(request.getParameter("id"));
		Plane plane = new Plane();
		BeanUtils.copyProperties(plane, form);
		plane.setId(planeId);
		PlaneManager.getInstance().updatePlaneInfo(plane);
		return mapping.findForward("success");
	}
}
