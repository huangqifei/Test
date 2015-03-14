package travel.struts.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.BBS;
import travel.struts.data.User;
import travel.struts.datemanager.BBSManager;

public class BBSAppearPostAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String map = "login";
		if(request.getSession().getAttribute("user") == null) {
			map = "login";
		} else {
			int uid = ((User)request.getSession().getAttribute("user")).getId();
			System.out.println(uid);
			BBS bbs = new BBS();
			BeanUtils.copyProperties(bbs, form);
			DateFormat formatter  = new SimpleDateFormat("yyyy.MM.dd");
			String date = formatter.format(new Date());
			bbs.setDate(date);
			bbs.setAccess(0);
			bbs.setReply(0);
			bbs.setUid(uid);
			BBSManager.getInstance().appearPost(bbs);
			map = "success";
		}
		return mapping.findForward(map);
		
	}
}
