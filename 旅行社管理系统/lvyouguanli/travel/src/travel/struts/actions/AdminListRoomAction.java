package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.datemanager.HotelManager;

public class AdminListRoomAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Hotel hotel = HotelManager.getInstance().findHotelById(id);
		List queryList = HotelManager.getInstance().listAllRoomByName(hotel.getName());
		request.setAttribute("hotel", hotel);
		request.setAttribute("queryList", queryList);
		
		return mapping.findForward("success");
	}
	
}
