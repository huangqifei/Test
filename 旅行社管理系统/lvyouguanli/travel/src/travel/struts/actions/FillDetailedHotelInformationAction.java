package travel.struts.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.DetailInfo;
import travel.struts.data.Hotel;
import travel.struts.data.User;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.PlaneManager;

public class FillDetailedHotelInformationAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String map = null;
		if(request.getSession().getAttribute("user") == null) {
			map = "login";
		} else {
			int hotelId = Integer.parseInt(request.getParameter("id"));
			User user = (User)request.getSession().getAttribute("user");
			Hotel hotel = new Hotel();
			BeanUtils.copyProperties(hotel, form);
			hotel.setName((HotelManager.getInstance().findHotelById(hotelId)).getName());
			int reserved = HotelManager.getInstance().judgeRoomReserved(hotel);
			if(reserved == 0) {
				HotelManager.getInstance().setReservedRoom(hotel);
				HotelManager.getInstance().reserveHotelRoom(hotel, user.getId());
				map = "success";
			} else {
				String errorMessege = "请确认你的操作，确认该酒店已经被预订。";
				request.setAttribute("errorMessege", errorMessege);
				map = "error";
			}
		}
		return mapping.findForward(map);
	}

}
