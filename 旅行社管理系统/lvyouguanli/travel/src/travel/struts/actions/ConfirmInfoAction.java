package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.User;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.PlaneManager;
import travel.struts.datemanager.SightManager;

public class ConfirmInfoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String map = "";
		if(request.getSession().getAttribute("user") != null) {
			User user = (User)request.getSession().getAttribute("user");
			List hotelList = HotelManager.getInstance().listUserReservedHotelInfo(user.getId());
			request.setAttribute("hotelList", hotelList);
			List groupList = SightManager.getInstance().listUserReservedGroupInfo(user.getId());
			request.setAttribute("groupList", groupList);
			List planeList = PlaneManager.getInstance().listUserReservedPlaneInfo(user.getId());
			request.setAttribute("planeList", planeList);
			map = "success";
		} else {
			map = "login";
		}
		return mapping.findForward(map);

	}
}
