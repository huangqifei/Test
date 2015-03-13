package travel.struts.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.datemanager.HotelManager;

public class QueryHotelInfoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(hotel, form);
		String cityName = hotel.getCity();
		String star = hotel.getStar();
		String name = hotel.getName();
		List hotelList = HotelManager.getInstance().queryHotelManager(cityName, star, name);
		request.setAttribute("hotelList", hotelList);
		return mapping.findForward("success");
	}
}
