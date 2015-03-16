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
	 * �г����еĺ�����Ϣ
	 * @return
	 */
	public List listPlaneInfo() {
		List planeList = DBOFactory.getInstance().getDBO().listPlaneInfo();
		return planeList;
	}
	
	/**
	 * ͨ��ID��ѯ����
	 * @param id
	 * @return
	 */
	public Plane findPlaneById(int id) {
		Plane plane = DBOFactory.getInstance().getDBO().findPlaneById(id);
		return plane;
	}
	
	/**
	 * �жϸ��û��Ƿ���Ԥ������
	 * @param userName ��վ���û�����������ʵ������
	 * @return 1���Ѿ����˸��û��Ķ������Ҹ��û�û��Ԥ���κκ��ࡣ
	 * 		   2���Ѿ����˸��û��Ķ������Ҹ��û��Ѿ�Ԥ���˺��ࡣ
	 * 		   3�����û���û���κ�Ԥ����Ϣ��
	 */
	public int queryHasPlaneReserveInfo(String userName) {
		return DBOFactory.getInstance().getDBO().queryHasPlaneReserveInfo(userName);
	}
	
	/**
	 * ��д�û�Ԥ��������Ϣ
	 * @param user
	 * @param planeId
	 */
	public void fillPlaneDetailedInfomation(User user, int planeId) {
		DBOFactory.getInstance().getDBO().fillPlaneDetailedInfomation(user, planeId);
	}

	/**
	 * ���ݺ���Ų�ѯ����
	 * @param number
	 * @return
	 */
	public List listPlaneByNumber(String number) {
		return DBOFactory.getInstance().getDBO().listPlaneByNumber(number);
	}
	
	/**
	 * ���ݳ����ز�ѯ����
	 * @param from
	 * @return
	 */
	public List listPlaneByFrom(String fromcity) {
		return DBOFactory.getInstance().getDBO().listPlaneByFrom(fromcity);
	}
	
	/**
	 * ���¼�Ԥ����������
	 * @param planeId
	 * @param hasPeople
	 */
	public void updatePlaneDetailedInfomation(int planeId, int hasPeople) {
		DBOFactory.getInstance().getDBO().updatePlaneDetailedInfomation(planeId, hasPeople);
	}
	
	/**
	 * �����û�Ԥ���������Ϣ
	 * @param planeId
	 * @param fly_type
	 * @param userId
	 * @param reservedPeople
	 */
	public void updateUserReservePlaneInfo(Plane plane, String fly_type, int userId, int reservedPeople) {
		DBOFactory.getInstance().getDBO().updateUserReservePlaneInfo(plane, fly_type, userId, reservedPeople);
	}
	
	/**
	 * �г��û�Ԥ���ĺ�����Ϣ
	 * @param userId
	 * @return
	 */
	public List listUserReservedPlaneInfo(int userId) {
		return DBOFactory.getInstance().getDBO().listUserReservedPlaneInfo(userId);
	}
	
	/**
	 * ���º�����Ϣ������Ա�޸�ҳ�棩
	 * @param plane
	 */
	public void updatePlaneInfo(Plane plane) {
		DBOFactory.getInstance().getDBO().updatePlaneInfo(plane);
	}
	
	/**
	 * ����IDɾ��������Ϣ
	 * @param planeId
	 */
	public void deletePlaneById(int planeId) {
		DBOFactory.getInstance().getDBO().deletePlaneById(planeId);
	}
	
	/**
	 * ���Ӻ�����Ϣ������Ա��
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
