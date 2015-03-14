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
	 * 列出所有景点名称
	 * @return
	 */
	public List listSightName() {
		List sightList = DBOFactory.getInstance().getDBO().listSightName();
		return sightList;
	}
	
	
	/**
	 * 通过ID查询景点信息
	 * @param id
	 * @return
	 */
	public Sight findSightById(int id) {
		Sight sight = DBOFactory.getInstance().getDBO().findSightById(id);
		return sight;
	}
	
	/**
	 * 根据景点ID查询到该景点的旅游团
	 * @param id
	 * @return
	 */
	public List listGroupBySightName(String sightName) {
		List groupList = DBOFactory.getInstance().getDBO().listGroupBySightName(sightName);
		return groupList;
	}
	
	/**
	 * 通过旅游团ID查询旅游团信息
	 * @param groupId
	 * @return
	 */
	public TravelGroup findGroupById(int groupId) {
		TravelGroup group = DBOFactory.getInstance().getDBO().findGroupByid(groupId);
		return group;
	}
	
	/**
	 * 通过旅游团ID查询该旅游团去的景点
	 * @param groupId
	 * @return
	 */
	public List listSightByGroupId(int groupId) {
		List sightList = DBOFactory.getInstance().getDBO().listSightByGroupId(groupId);
		return sightList;
	}
	
	/**
	 * 通过城市名称查询该城市的景点
	 * @param cityName
	 * @return
	 */
	public List listSightByCityName(String cityName) {
		List sightList = DBOFactory.getInstance().getDBO().listSightByCityName(cityName);
		return sightList;
	}
	
	/**
	 * 判断该用户是否有预订东东
	 * @param userName 网站的用户名（不是真实姓名）
	 * @return 1：已经有了该用户的订单，且该用户没有预订任何旅游团。
	 * 		   2：已经有了该用户的订单，且该用户已经预订了任何旅游团。
	 * 		   3：该用户还没有任何预订信息。
	 */
	public int queryHasGroupReserveInfo(String userName) {
		int sign =  DBOFactory.getInstance().getDBO().queryHasGroupReserveInfo(userName);
		return sign;
	}
	
	/**
	 * 更新用户订单信息
	 * @param hotelId
	 */
	public void updateGroupDetailedInfomation(int groupId) {
		DBOFactory.getInstance().getDBO().updateGroupDetailedInfomation(groupId);
	}
	
	/**
	 * 填写旅游团预订信息
	 * @param detailInfo 客户详细信息
	 * @param hotelId 景点的ID
	 * @param userName 用户名称
	 */
	public void fillGroupDetailedInfomation(DetailInfo detailInfo, int groupId, String userName) {
		DBOFactory.getInstance().getDBO().fillGroupDetailedInfomation(detailInfo, groupId, userName);
	}
	
	public List listSightBySightName(String sightName) {
		List sightList = DBOFactory.getInstance().getDBO().listSightBySightName(sightName);
		return sightList;
	}
	
	/**
	 * 根据城市名查询景点
	 * @param cityName
	 * @param sightName
	 * @return
	 */
	public List listSightBySightCityName(String cityName,String sightName) {
		List sightList = DBOFactory.getInstance().getDBO().listSightBySightCityName(cityName, sightName);
		return sightList;
	}
	
	/**
	 * 根据旅游团ID查询已有人数
	 * @param groupId
	 * @return
	 */
	public int findHasReservedPeopleByGroupId(int groupId) {
		return DBOFactory.getInstance().getDBO().findHasReservedPeopleByGroupId(groupId);
	}
	
	/**
	 * 更新group_info表，更新已有人数
	 * @param groupId
	 * @param hasPeople
	 */
	public void reserveGroup(int groupId, int hasPeople) {
		DBOFactory.getInstance().getDBO().reserveGroup(groupId, hasPeople);
	}
	
	/**
	 * 更新预订信息，表group_reserve;
	 * @param group
	 * @param userId
	 * @param reservepeople
	 */
	public void updateGroupReserved(TravelGroup group, int userId, int reservepeople) {
		DBOFactory.getInstance().getDBO().updateGroupReserved(group, userId, reservepeople);
	}
	
	/**
	 * 列出游客预订的信息
	 * @param userId
	 * @return
	 */
	public List listUserReservedGroupInfo(int userId) {
		return DBOFactory.getInstance().getDBO().listUserReservedGroupInfo(userId);
	}
	
	/**
	 * 根据旅游团名检索所去的景点 group_info
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
	 * 更新景点信息
	 * @param sight
	 */
	public void updateSightInfo(Sight sight) {
		DBOFactory.getInstance().getDBO().updateSightInfo(sight);
	}
	
	/**
	 * 根据景点ID删除景点信息
	 * @param sightId
	 */
	public void deleteSightById(int sightId) {
		DBOFactory.getInstance().getDBO().deleteSightById(sightId);
	}
	
	/**
	 * 增加景点信息
	 * @param sight
	 */
	public void sightAdd(Sight sight) {
		DBOFactory.getInstance().getDBO().sightAdd(sight);
	}
	
	/**
	 * 只取出景点的名称,为首页所用.
	 * @return
	 */
	public List listCityNameForIndex() {
		return DBOFactory.getInstance().getDBO().listCityNameForIndex();
	}
	
	/**
	 * 取消旅游团预订信息
	 * @param groupId
	 */
	public void groupCancelReserved(int groupId) {
		DBOFactory.getInstance().getDBO().groupCancelReserved(groupId);
	}
	
}
