package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Hotel;
import travel.struts.data.Sight;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.SightManager;

public class HotelAddAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Hotel hotel = new Hotel();
		BeanUtils.copyProperties(hotel, form);
		HotelManager.getInstance().hotelAdd(hotel);
		return mapping.findForward("success");
	}
}
