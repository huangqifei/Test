package travel.struts.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.data.User;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.SightManager;

public class ReserveHotelAction extends Action {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Hotel hotel = HotelManager.getInstance().findHotelById(id);
//		List hotelList = HotelManager.getInstance().listHotelReserveInfo(hotel.getName());
		List queryList = HotelManager.getInstance().listRoomByName(hotel.getName());
		request.setAttribute("hotel", hotel);
//		request.setAttribute("hotelList", hotelList);
		request.setAttribute("queryList", queryList);
		DateFormat formatter  = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		String s = formatter.format(new Date());
		String year = null;
		String month = null;
		String day = null;
		year = s.substring(0, 4);
		month = s.substring(5, s.length());
		month = month.substring(0, month.indexOf("."));
		day = s.substring(s.indexOf(".", 6), s.length());
		day = day.substring(1, day.indexOf(".", 1));
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		return mapping.findForward("success");
	}

}
