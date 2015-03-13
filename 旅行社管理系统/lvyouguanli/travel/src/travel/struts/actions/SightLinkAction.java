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

public class SightLinkAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Sight sight = SightManager.getInstance().findSightById(id);
		String sightName = sight.getName();
		List groupList = SightManager.getInstance().listGroupBySightName(sightName);
		request.setAttribute("sight", sight);
		request.setAttribute("group", groupList);
		return mapping.findForward("success");
	}

}
