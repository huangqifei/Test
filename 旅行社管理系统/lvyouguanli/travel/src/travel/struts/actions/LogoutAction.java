package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.PlaneManager;
import travel.struts.datemanager.SightManager;

public class LogoutAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().setAttribute("user", null);
		List hotelList = HotelManager.getInstance().listHotel();
		List sightList = SightManager.getInstance().listSightName();
		List sightName = SightManager.getInstance().listCityNameForIndex();
		List planeList = PlaneManager.getInstance().listPlaneInfo();
		request.setAttribute("hotel", hotelList);
		request.setAttribute("sight", sightList);
		request.setAttribute("sightName", sightName);
		request.setAttribute("plane", planeList);
		return mapping.findForward("success");
	}
}
