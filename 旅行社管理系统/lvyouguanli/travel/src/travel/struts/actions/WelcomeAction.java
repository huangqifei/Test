package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.datemanager.BBSManager;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.PlaneManager;
import travel.struts.datemanager.SightManager;

public class WelcomeAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List hotelList = HotelManager.getInstance().listHotel();
		List sightList = SightManager.getInstance().listSightName();
		List sightName = SightManager.getInstance().listCityNameForIndex();
		List planeList = PlaneManager.getInstance().listPlaneInfo();
		List bbsList = BBSManager.getInstance().bbsList();
		request.setAttribute("hotel", hotelList);
		request.setAttribute("sight", sightList);
		request.setAttribute("sightName", sightName);
		request.setAttribute("plane", planeList);
		request.setAttribute("bbsList", bbsList);
		return mapping.findForward("success");
	}
}
