package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.datemanager.SightManager;

public class UserGroupCancelReservedAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int groupId = Integer.parseInt(request.getParameter("id"));
		SightManager.getInstance().groupCancelReserved(groupId);
		return mapping.findForward("success");
	}

}
