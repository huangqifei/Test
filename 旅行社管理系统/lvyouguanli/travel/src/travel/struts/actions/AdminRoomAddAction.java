package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.datemanager.HotelManager;

public class AdminRoomAddAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Hotel h = HotelManager.getInstance().findHotelById(id);
		String hotelName = h.getName();
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(hotel, form);
		hotel.setName(hotelName);
		HotelManager.getInstance().addRoom(hotel);
		return mapping.findForward("success");
	}
}
