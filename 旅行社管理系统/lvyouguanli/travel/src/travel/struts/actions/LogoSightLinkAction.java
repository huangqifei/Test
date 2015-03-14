package travel.struts.actions;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Sight;
import travel.struts.datemanager.SightManager;

public class LogoSightLinkAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List sightList = SightManager.getInstance().listSightName();
		request.setAttribute("sight", sightList);
		return mapping.findForward("success");
	}
}
