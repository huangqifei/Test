package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.actionforms.DetailInfoActionForm;
import travel.struts.actionforms.SightActionForm;
import travel.struts.data.DetailInfo;
import travel.struts.data.TravelGroup;
import travel.struts.data.User;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.SightManager;
import travel.struts.factory.DBOFactory;

public class FillDetailedGroupInformationAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String map = null;
		if(request.getSession().getAttribute("user") == null) {
			map = "login";
		} else {
			int groupId = Integer.parseInt(request.getParameter("id"));
			String userName = ((User)request.getSession().getAttribute("user")).getName();
			User user = (User)request.getSession().getAttribute("user");
			int reservepeople = ((SightActionForm)form).getReservepeople();
			int hasPeople = SightManager.getInstance().findHasReservedPeopleByGroupId(groupId);
			hasPeople = hasPeople + reservepeople;
			SightManager.getInstance().reserveGroup(groupId, hasPeople);
			TravelGroup group = SightManager.getInstance().findGroupById(groupId);
			SightManager.getInstance().updateGroupReserved(group, user.getId(), reservepeople);
			map = "success";
		}
		return mapping.findForward(map);
	}

}
