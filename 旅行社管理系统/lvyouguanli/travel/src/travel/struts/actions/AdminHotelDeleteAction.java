package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.SightManager;

public class AdminHotelDeleteAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int hotelId = Integer.parseInt(request.getParameter("id"));
		HotelManager.getInstance().deleteHotelById(hotelId);
		return mapping.findForward("success");
	}
}
