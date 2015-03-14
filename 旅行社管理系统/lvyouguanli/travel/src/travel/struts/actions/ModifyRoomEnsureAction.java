package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.actionforms.HotelActionForm;
import travel.struts.data.Hotel;
import travel.struts.datemanager.HotelManager;

public class ModifyRoomEnsureAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int roomId = Integer.parseInt(request.getParameter("roomid"));
		Hotel hotel1 = new Hotel();
		BeanUtils.copyProperties(hotel1, form);
		hotel1.setId(roomId);
		HotelManager.getInstance().updateHotelRoomInfo(hotel1);
		
		int hotelId = Integer.parseInt(request.getParameter("hotelid"));
		Hotel hotel2 = HotelManager.getInstance().findHotelById(hotelId);
		List queryList = HotelManager.getInstance().listAllRoomByName(hotel2.getName());
		request.setAttribute("hotel", hotel2);
		request.setAttribute("queryList", queryList);
		
		return mapping.findForward("success");
	}
}
