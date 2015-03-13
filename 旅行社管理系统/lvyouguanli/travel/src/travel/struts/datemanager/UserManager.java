package travel.struts.datemanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import travel.struts.data.User;
import travel.struts.db.DateBaseOperator;
import travel.struts.factory.DBOFactory;

public class UserManager {
	
	private static UserManager instance = new UserManager();
	
	public static UserManager getInstance() {
		return instance;
	}
	
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	public User loginManager(User user) {
		User user1 = DBOFactory.getInstance().getDBO().findUserByName(user);
		return user1;
	}

	/*
	 * 用户删除模块
	 */
	public void userDelete(User user) {
		List touristList = new ArrayList();
		touristList = DBOFactory.getInstance().getDBO().touristQuery();
		StringBuffer sbfSql = new StringBuffer();
		for(int i=0; i<touristList.size(); i++) {
			User tourist = (User)touristList.get(i);
			sbfSql.append("'")
			.append(tourist.getName())
			.append("'")
			.append(",");
		}
		String nameInfo = sbfSql.substring(0, sbfSql.length()-1);
		DBOFactory.getInstance().getDBO().userDelete(nameInfo);
	}
	
	/**
	 * 添加用户模块
	 * @param user
	 */
	public void userAdd(User user) {
		DBOFactory.getInstance().getDBO().userAdd(user);
	}
	
	/**
	 * 修改游客个人信息
	 * @param user
	 */
	public void modifyUserInfo(User user) {
		DBOFactory.getInstance().getDBO().modifyUserInfo(user);
	}
	
	public User findUserById(int userId) {
		return DBOFactory.getInstance().getDBO().findUserById(userId);
	}
	
	/**
	 * 判断用户是否存在...返回true说明不存在,false说明存在
	 * @param user
	 * @return
	 */
	public boolean isUserExist(User user) {
		return DBOFactory.getInstance().getDBO().isUserExist(user);
	}
}
