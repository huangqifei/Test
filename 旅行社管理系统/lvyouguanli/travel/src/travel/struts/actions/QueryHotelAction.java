package travel.struts.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.actionforms.HotelActionForm;
import travel.struts.data.Hotel;
import travel.struts.datemanager.HotelManager;

public class QueryHotelAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		int sign = Integer.parseInt(request.getParameter("type"));
		String type = null;
		if(sign == 1) {
			type = "单人房";
		} else {
			type = "双人房";
		}
		Hotel hotel = HotelManager.getInstance().findHotelById(id);
		List hotelList = HotelManager.getInstance().listHotelReserveInfo(hotel.getName());
		request.setAttribute("hotel", hotel);
		request.setAttribute("hotelList", hotelList);
		List typeList = HotelManager.getInstance().listHotelBySigleType(type);
		List queryList = new ArrayList();
		Iterator it1 = typeList.iterator();
		while(it1.hasNext()) {
			Hotel h1 = (Hotel)it1.next();
			String s1 = hotel.getName();
			String s2 = h1.getName();
			if(s1.equals(s2)) {
				queryList.add(h1);
			}
		}
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
		request.setAttribute("queryList", queryList);
		return mapping.findForward("success");
	}
}
