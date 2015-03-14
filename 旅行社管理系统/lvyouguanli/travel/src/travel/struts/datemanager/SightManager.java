package travel.struts.datemanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import travel.struts.data.DetailInfo;
import travel.struts.data.Sight;
import travel.struts.data.TravelGroup;
import travel.struts.factory.DBOFactory;

public class SightManager {
	
	private static SightManager instance = new SightManager();
	
	public static SightManager getInstance() {
		return instance;
	}
	
	/**
	 * �г����о�������
	 * @return
	 */
	public List listSightName() {
		List sightList = DBOFactory.getInstance().getDBO().listSightName();
		return sightList;
	}
	
	
	/**
	 * ͨ��ID��ѯ������Ϣ
	 * @param id
	 * @return
	 */
	public Sight findSightById(int id) {
		Sight sight = DBOFactory.getInstance().getDBO().findSightById(id);
		return sight;
	}
	
	/**
	 * ���ݾ���ID��ѯ���þ����������
	 * @param id
	 * @return
	 */
	public List listGroupBySightName(String sightName) {
		List groupList = DBOFactory.getInstance().getDBO().listGroupBySightName(sightName);
		return groupList;
	}
	
	/**
	 * ͨ��������ID��ѯ��������Ϣ
	 * @param groupId
	 * @return
	 */
	public TravelGroup findGroupById(int groupId) {
		TravelGroup group = DBOFactory.getInstance().getDBO().findGroupByid(groupId);
		return group;
	}
	
	/**
	 * ͨ��������ID��ѯ��������ȥ�ľ���
	 * @param groupId
	 * @return
	 */
	public List listSightByGroupId(int groupId) {
		List sightList = DBOFactory.getInstance().getDBO().listSightByGroupId(groupId);
		return sightList;
	}
	
	/**
	 * ͨ���������Ʋ�ѯ�ó��еľ���
	 * @param cityName
	 * @return
	 */
	public List listSightByCityName(String cityName) {
		List sightList = DBOFactory.getInstance().getDBO().listSightByCityName(cityName);
		return sightList;
	}
	
	/**
	 * �жϸ��û��Ƿ���Ԥ������
	 * @param userName ��վ���û�����������ʵ������
	 * @return 1���Ѿ����˸��û��Ķ������Ҹ��û�û��Ԥ���κ������š�
	 * 		   2���Ѿ����˸��û��Ķ������Ҹ��û��Ѿ�Ԥ�����κ������š�
	 * 		   3�����û���û���κ�Ԥ����Ϣ��
	 */
	public int queryHasGroupReserveInfo(String userName) {
		int sign =  DBOFactory.getInstance().getDBO().queryHasGroupReserveInfo(userName);
		return sign;
	}
	
	/**
	 * �����û�������Ϣ
	 * @param hotelId
	 */
	public void updateGroupDetailedInfomation(int groupId) {
		DBOFactory.getInstance().getDBO().updateGroupDetailedInfomation(groupId);
	}
	
	/**
	 * ��д������Ԥ����Ϣ
	 * @param detailInfo �ͻ���ϸ��Ϣ
	 * @param hotelId �����ID
	 * @param userName �û�����
	 */
	public void fillGroupDetailedInfomation(DetailInfo detailInfo, int groupId, String userName) {
		DBOFactory.getInstance().getDBO().fillGroupDetailedInfomation(detailInfo, groupId, userName);
	}
	
	public List listSightBySightName(String sightName) {
		List sightList = DBOFactory.getInstance().getDBO().listSightBySightName(sightName);
		return sightList;
	}
	
	/**
	 * ���ݳ�������ѯ����
	 * @param cityName
	 * @param sightName
	 * @return
	 */
	public List listSightBySightCityName(String cityName,String sightName) {
		List sightList = DBOFactory.getInstance().getDBO().listSightBySightCityName(cityName, sightName);
		return sightList;
	}
	
	/**
	 * ����������ID��ѯ��������
	 * @param groupId
	 * @return
	 */
	public int findHasReservedPeopleByGroupId(int groupId) {
		return DBOFactory.getInstance().getDBO().findHasReservedPeopleByGroupId(groupId);
	}
	
	/**
	 * ����group_info��������������
	 * @param groupId
	 * @param hasPeople
	 */
	public void reserveGroup(int groupId, int hasPeople) {
		DBOFactory.getInstance().getDBO().reserveGroup(groupId, hasPeople);
	}
	
	/**
	 * ����Ԥ����Ϣ����group_reserve;
	 * @param group
	 * @param userId
	 * @param reservepeople
	 */
	public void updateGroupReserved(TravelGroup group, int userId, int reservepeople) {
		DBOFactory.getInstance().getDBO().updateGroupReserved(group, userId, reservepeople);
	}
	
	/**
	 * �г��ο�Ԥ������Ϣ
	 * @param userId
	 * @return
	 */
	public List listUserReservedGroupInfo(int userId) {
		return DBOFactory.getInstance().getDBO().listUserReservedGroupInfo(userId);
	}
	
	/**
	 * ������������������ȥ�ľ��� group_info
	 * @param groupName
	 * @return
	 */
	public List listSightByGroupName(String groupName) {
		List sightList = new ArrayList();
		List sightList1 =  DBOFactory.getInstance().getDBO().listSightByGroupName(groupName);
		Iterator it = sightList1.iterator();
		while(it.hasNext()) {
			Sight s = (Sight)it.next();
			String sightName = s.getName();
			Sight sight = DBOFactory.getInstance().getDBO().findSightIdBySightName(sightName);
			sightList.add(sight);
		}
		return sightList;
	}
	
	/**
	 * ���¾�����Ϣ
	 * @param sight
	 */
	public void updateSightInfo(Sight sight) {
		DBOFactory.getInstance().getDBO().updateSightInfo(sight);
	}
	
	/**
	 * ���ݾ���IDɾ��������Ϣ
	 * @param sightId
	 */
	public void deleteSightById(int sightId) {
		DBOFactory.getInstance().getDBO().deleteSightById(sightId);
	}
	
	/**
	 * ���Ӿ�����Ϣ
	 * @param sight
	 */
	public void sightAdd(Sight sight) {
		DBOFactory.getInstance().getDBO().sightAdd(sight);
	}
	
	/**
	 * ֻȡ�����������,Ϊ��ҳ����.
	 * @return
	 */
	public List listCityNameForIndex() {
		return DBOFactory.getInstance().getDBO().listCityNameForIndex();
	}
	
	/**
	 * ȡ��������Ԥ����Ϣ
	 * @param groupId
	 */
	public void groupCancelReserved(int groupId) {
		DBOFactory.getInstance().getDBO().groupCancelReserved(groupId);
	}
	
}
