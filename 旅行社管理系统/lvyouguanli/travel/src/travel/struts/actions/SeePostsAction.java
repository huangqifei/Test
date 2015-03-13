package travel.struts.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.BBS;
import travel.struts.data.User;
import travel.struts.datemanager.BBSManager;
import travel.struts.datemanager.UserManager;

public class SeePostsAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int postId = Integer.parseInt(request.getParameter("id"));
		BBS post = BBSManager.getInstance().findPostById(postId);
		request.setAttribute("post", post);
		User user = UserManager.getInstance().findUserById(post.getUid());
		request.setAttribute("userinfo", user);
		List replyList = BBSManager.getInstance().listReplyByPostId(postId);
		BBSManager.getInstance().addAccess(postId);
		request.setAttribute("replyList", replyList);
		return mapping.findForward("success");
	}
}
