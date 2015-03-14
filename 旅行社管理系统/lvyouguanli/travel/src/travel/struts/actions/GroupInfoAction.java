package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Sight;
import travel.struts.data.TravelGroup;
import travel.struts.datemanager.SightManager;

public class GroupInfoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int groupId = Integer.parseInt(request.getParameter("groupid"));
		int sightId = Integer.parseInt(request.getParameter("sightid"));

		Sight sight = SightManager.getInstance().findSightById(sightId);
		TravelGroup group = SightManager.getInstance().findGroupById(groupId);
		String groupName = group.getName();
		List sightList = SightManager.getInstance().listSightByGroupName(groupName);
		request.setAttribute("group", group);
		request.setAttribute("sight", sight);
		request.setAttribute("sightList", sightList);
		return mapping.findForward("success");
	}
}
