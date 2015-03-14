package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Sight;
import travel.struts.datemanager.SightManager;

public class CityLinkAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Sight sight = SightManager.getInstance().findSightById(id);
		String cityName = sight.getCity();
		List sightList = SightManager.getInstance().listSightByCityName(cityName);
		request.setAttribute("sightList", sightList);
		return mapping.findForward("success");
	}

}
