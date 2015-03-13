package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.User;
import travel.struts.datemanager.UserManager;

public class ModifyUserInfoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String map = "login";
		if(request.getSession().getAttribute("user") == null) {
			map = "login";
		} else {
			User user = (User)request.getSession().getAttribute("user");
			BeanUtils.copyProperties(user, form);
			UserManager.getInstance().modifyUserInfo(user);
			map = "success";
		}
		
		return mapping.findForward(map);
	}
}
