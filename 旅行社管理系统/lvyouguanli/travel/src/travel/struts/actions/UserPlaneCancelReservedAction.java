package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.data.Plane;
import travel.struts.datemanager.PlaneManager;

public class UserPlaneCancelReservedAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int planeId = Integer.parseInt(request.getParameter("id"));
		Plane plane = PlaneManager.getInstance().findPlaneByIdInPlane(planeId);
		PlaneManager.getInstance().planeCancelReserved(planeId);
		Plane plane1 = PlaneManager.getInstance().findPlaneByNumber(plane.getNumber());
		int haspeople = plane1.getHaspeople() - plane.getReservedPeople();
		plane1.setHaspeople(haspeople);
		PlaneManager.getInstance().planeEnsurePeople(plane1);
		return mapping.findForward("success");
	}
}
