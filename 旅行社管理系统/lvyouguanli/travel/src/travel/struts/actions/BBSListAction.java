package travel.struts.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.BBS;
import travel.struts.data.Reply;
import travel.struts.datemanager.BBSManager;

public class BBSListAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<BBS> bbsList = BBSManager.getInstance().bbsList();
		//add by huangqifei at 2015-03-11 start
//		List<Reply> replyList = BBSManager.getInstance().getRepayList();
//		//match postId with post and reply;
//		for(BBS bbs:bbsList){
//			List<Reply> arrReplyList = new ArrayList<Reply>();
//			for(Reply reply:replyList){
//				if(reply.getPostId() == bbs.getId()){
//					arrReplyList.add(reply);
//				}
//			}
//			bbs.setReplyList(arrReplyList);
//		}
		
		//add by huangqifei at 2015-03-11 end
		request.setAttribute("bbsList", bbsList);
		
//		request.setAttribute("replyList", replyList);
		return mapping.findForward("success");
	}
}
