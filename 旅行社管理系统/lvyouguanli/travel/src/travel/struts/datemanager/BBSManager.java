package travel.struts.datemanager;

import java.util.List;

import travel.struts.data.BBS;
import travel.struts.data.Reply;
import travel.struts.factory.DBOFactory;

public class BBSManager {
	
	private static BBSManager instance = new BBSManager();
	
	public static BBSManager getInstance() {
		return instance;
	}
	
	public List bbsList() {
		return DBOFactory.getInstance().getDBO(). bbsList();
	}
	
	public BBS findPostById(int postId) {
		return DBOFactory.getInstance().getDBO().findPostById(postId);
	}
	
	public List<Reply> listReplyByPostId(int postId) {
		return DBOFactory.getInstance().getDBO().listReplyByPostId(postId);
	}
	
	public List getRepayList(){
		return DBOFactory.getInstance().getDBO().listReply();
	}
	
	/**
	 * 回帖
	 * @param postId
	 * @param userId
	 * @param bbs
	 */
	public void addPostReply(int postId, int userId, BBS bbs) {
		DBOFactory.getInstance().getDBO().addPostReply(postId, userId, bbs);
	}
	
	/**
	 * 更新访问量，每有一个人访问就会加一.
	 * @param postId
	 */
	public void addAccess(int postId) {
		DBOFactory.getInstance().getDBO().addAccess(postId);
	}
	
	public void addReply(int postId) {
		DBOFactory.getInstance().getDBO().addReply(postId);
	}
	
	public void appearPost(BBS bbs) {
		DBOFactory.getInstance().getDBO().appearPost(bbs);
	}
	
	/**
	 * 删贴
	 * @param postId
	 */
	public void deletePostById(int postId) {
		DBOFactory.getInstance().getDBO().deletePostById(postId);
	}
	
	public void deleteReplyByid(int replyId) {
		DBOFactory.getInstance().getDBO().deleteReplyByid(replyId);
	}

}
