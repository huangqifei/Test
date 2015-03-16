package travel.struts.datemanager;

import java.util.List;

import travel.struts.data.DetailInfo;
import travel.struts.data.Plane;
import travel.struts.data.User;
import travel.struts.factory.DBOFactory;

public class PlaneManager {
	
	private static PlaneManager instance = new PlaneManager();
	
	public static PlaneManager getInstance() {
		return instance;
	}
	
	/**
	 * 列出所有的航班信息
	 * @return
	 */
	public List listPlaneInfo() {
		List planeList = DBOFactory.getInstance().getDBO().listPlaneInfo();
		return planeList;
	}
	
	/**
	 * 通过ID查询航班
	 * @param id
	 * @return
	 */
	public Plane findPlaneById(int id) {
		Plane plane = DBOFactory.getInstance().getDBO().findPlaneById(id);
		return plane;
	}
	
	/**
	 * 判断该用户是否有预订东东
	 * @param userName 网站的用户名（不是真实姓名）
	 * @return 1：已经有了该用户的订单，且该用户没有预订任何航班。
	 * 		   2：已经有了该用户的订单，且该用户已经预订了航班。
	 * 		   3：该用户还没有任何预订信息。
	 */
	public int queryHasPlaneReserveInfo(String userName) {
		return DBOFactory.getInstance().getDBO().queryHasPlaneReserveInfo(userName);
	}
	
	/**
	 * 填写用户预订航班信息
	 * @param user
	 * @param planeId
	 */
	public void fillPlaneDetailedInfomation(User user, int planeId) {
		DBOFactory.getInstance().getDBO().fillPlaneDetailedInfomation(user, planeId);
	}

	/**
	 * 根据航班号查询航班
	 * @param number
	 * @return
	 */
	public List listPlaneByNumber(String number) {
		return DBOFactory.getInstance().getDBO().listPlaneByNumber(number);
	}
	
	/**
	 * 根据出发地查询航班
	 * @param from
	 * @return
	 */
	public List listPlaneByFrom(String fromcity) {
		return DBOFactory.getInstance().getDBO().listPlaneByFrom(fromcity);
	}
	
	/**
	 * 更新己预订航班人数
	 * @param planeId
	 * @param hasPeople
	 */
	public void updatePlaneDetailedInfomation(int planeId, int hasPeople) {
		DBOFactory.getInstance().getDBO().updatePlaneDetailedInfomation(planeId, hasPeople);
	}
	
	/**
	 * 更新用户预订航班的信息
	 * @param planeId
	 * @param fly_type
	 * @param userId
	 * @param reservedPeople
	 */
	public void updateUserReservePlaneInfo(Plane plane, String fly_type, int userId, int reservedPeople) {
		DBOFactory.getInstance().getDBO().updateUserReservePlaneInfo(plane, fly_type, userId, reservedPeople);
	}
	
	/**
	 * 列出用户预订的航班信息
	 * @param userId
	 * @return
	 */
	public List listUserReservedPlaneInfo(int userId) {
		return DBOFactory.getInstance().getDBO().listUserReservedPlaneInfo(userId);
	}
	
	/**
	 * 更新航班信息（管理员修改页面）
	 * @param plane
	 */
	public void updatePlaneInfo(Plane plane) {
		DBOFactory.getInstance().getDBO().updatePlaneInfo(plane);
	}
	
	/**
	 * 根据ID删除航班信息
	 * @param planeId
	 */
	public void deletePlaneById(int planeId) {
		DBOFactory.getInstance().getDBO().deletePlaneById(planeId);
	}
	
	/**
	 * 增加航班信息（管理员）
	 * @param plane
	 * @throws Exception 
	 */
	public void planeAdd(Plane plane) throws Exception {
		DBOFactory.getInstance().getDBO().planeAdd(plane);
	}
	
	public void planeCancelReserved(int planeId) {
		DBOFactory.getInstance().getDBO().planeCancelReserved(planeId);
	}
	
	public Plane findPlaneByIdInPlane(int id) {
		return DBOFactory.getInstance().getDBO().findPlaneByIdInPlane(id);
	}
	
	public Plane findPlaneByNumber(String number) {
		return DBOFactory.getInstance().getDBO().findPlaneByNumber(number);
	}
	
	public void planeEnsurePeople(Plane plane) {
		DBOFactory.getInstance().getDBO().planeEnsurePeople(plane);
	}
}
