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

import travel.struts.actionforms.BBSActiomForm;
import travel.struts.data.BBS;
import travel.struts.data.User;
import travel.struts.datemanager.BBSManager;

public class BBSAppearReplyAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int userId = ((User)(request.getSession().getAttribute("user"))).getId();
		int postId = Integer.parseInt(request.getParameter("id"));
		int replyId = Integer.parseInt(request.getParameter("rid"));
		replyId ++;
		BBS bbs = new BBS();
		String content = ((BBSActiomForm)form).getContent();
		bbs.setContent(content);
		bbs.setRid(replyId);
		DateFormat formatter  = new SimpleDateFormat("yyyy.MM.dd");
		String date = formatter.format(new Date());
		bbs.setDate(date);
		BBSManager.getInstance().addPostReply(postId, userId, bbs);
		
		//增加回复人数
		BBSManager.getInstance().addReply(postId);
		return mapping.findForward("success");
	}
}
