package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.data.Sight;
import travel.struts.data.TravelGroup;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.SightManager;

public class ReserveGroupAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int sightId = Integer.parseInt(request.getParameter("sightid"));
		int groupId = Integer.parseInt(request.getParameter("groupid"));
		Sight sight = SightManager.getInstance().findSightById(sightId);
		TravelGroup group = SightManager.getInstance().findGroupById(groupId);
		request.setAttribute("group", group);
		request.setAttribute("sight", sight);
		return mapping.findForward("success");
	}
}
