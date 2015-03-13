package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.actionforms.DetailInfoActionForm;
import travel.struts.actionforms.PlaneActionForm;
import travel.struts.data.DetailInfo;
import travel.struts.data.Plane;
import travel.struts.data.User;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.PlaneManager;
import travel.struts.datemanager.SightManager;

public class FillDetailedPlaneInfomationAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String map = null;
		if(request.getSession().getAttribute("user") == null) {
			map = "login";
		} else {
			int planeId = Integer.parseInt(request.getParameter("id"));
			User user = (User)request.getSession().getAttribute("user");
			int flyType = Integer.parseInt(((PlaneActionForm)form).getFly_type());
			int reservedPeople = ((PlaneActionForm)form).getReservedpeople();
			String fly_type = null;
			if(flyType == 1) {
				fly_type = "µ¥³Ì";
			} else if(flyType == 2) {
				fly_type = "Íù·µ";
			}
			Plane plane = PlaneManager.getInstance().findPlaneById(planeId);
			int hasPeople = reservedPeople + plane.getHaspeople();
			PlaneManager.getInstance().updatePlaneDetailedInfomation(planeId, hasPeople);
			PlaneManager.getInstance().updateUserReservePlaneInfo(plane, fly_type, user.getId(), reservedPeople);
			map = "success";
		}
		return mapping.findForward(map);
	}
}
