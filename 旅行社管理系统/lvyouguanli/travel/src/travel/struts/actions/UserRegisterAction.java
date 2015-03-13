package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.actionforms.UserActionForm;
import travel.struts.data.User;
import travel.struts.datemanager.UserManager;

public class UserRegisterAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String map = null;
		User user = new User();
		BeanUtils.copyProperties(user, form);
		if(UserManager.getInstance().isUserExist(user)) {
			UserManager.getInstance().userAdd(user);
			map = "success";
		} else {
			request.setAttribute("exist", "该用户名已经存在");
			map = "error";
			request.setAttribute("user", user);
		}
		return mapping.findForward(map);
	}

}
