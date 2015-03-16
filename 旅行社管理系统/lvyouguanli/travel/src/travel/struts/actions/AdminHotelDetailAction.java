package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.datemanager.HotelManager;

public class AdminHotelDetailAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int hotelId = Integer.parseInt(request.getParameter("id"));
		Hotel hotel = HotelManager.getInstance().findHotelById(hotelId);
		request.setAttribute("hotel", hotel);
		return mapping.findForward("success");
	}
	
}
