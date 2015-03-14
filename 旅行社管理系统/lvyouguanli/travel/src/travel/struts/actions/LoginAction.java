package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.User;
import travel.struts.datemanager.UserManager;
import travel.struts.datemanager.HotelManager;
import travel.struts.datemanager.PlaneManager;
import travel.struts.datemanager.SightManager;


public class LoginAction extends Action {

	/**
	 * 登陆Action
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ErrorMessage = "";
		String map = null;
		User user = new User();
		User user_login = new User();			//从数据库中检索出的用户
		BeanUtils.copyProperties(user, form);	//用户输入的用户
		user_login = UserManager.getInstance().loginManager(user);
		if(user_login.getName() != null) {
			if(user.getPassword().equals(user_login.getPassword())) {
				user.setPassword("");
				map = "tourist";
				request.getSession().setAttribute("user", user_login);
				if(user_login.isAdmin()) {
					map = "admin";
				}
				
			} else {
				ErrorMessage = "密码不正确";
				map = "error";
			}
		} else {
			ErrorMessage = "用户不存在";
			map = "error";
		}
		request.setAttribute("message", ErrorMessage);
		List hotelList = HotelManager.getInstance().listHotel();
		List sightList = SightManager.getInstance().listSightName();
		List planeList = PlaneManager.getInstance().listPlaneInfo();
		List sightName = SightManager.getInstance().listCityNameForIndex();
		request.setAttribute("hotel", hotelList);
		request.setAttribute("sightName", sightName);
		request.setAttribute("sight", sightList);
		request.setAttribute("plane", planeList);
		return mapping.findForward(map);
	}

}
