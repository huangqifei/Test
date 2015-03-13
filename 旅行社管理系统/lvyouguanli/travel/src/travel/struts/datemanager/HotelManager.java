package travel.struts.datemanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import travel.struts.data.DetailInfo;
import travel.struts.data.Hotel;
import travel.struts.data.User;
import travel.struts.db.DateBaseOperator;
import travel.struts.factory.DBOFactory;

public class HotelManager {
	private static HotelManager instance = new HotelManager();
	
	public static HotelManager getInstance() {
		return instance;
	}

	
	public List listHotel() {
		List hotelList = DBOFactory.getInstance().getDBO().listHotel();
		return hotelList;
	}
	
	/**
	 * ͨ��ID��ѯ�Ƶ���Ϣ
	 * @param id
	 * @return
	 */
	public Hotel findHotelById(int id) {
		Hotel hotel = DBOFactory.getInstance().getDBO().findHotelById(id);
		return hotel;
	}
	
	/**
	 * ͨ����������ѯ�Ƶ�
	 * @param cityName
	 * @return
	 */
	public List listHotelByCityName(String cityName) {
		return DBOFactory.getInstance().getDBO().listHotelByCityName(cityName);
	}
	
	/**
	 * ��д�Ƶ�Ԥ����Ϣ
	 * @param detailInfo �ͻ���ϸ��Ϣ
	 * @param hotelId �Ƶ��ID
	 * @param userName �û�����
	 */
	public void fillHotelDetailedInfomation(User user, int hotelId, String userName) {
		DBOFactory.getInstance().getDBO().fillHotelDetailedInfomation(user, hotelId, userName);
	}
	

	
	/**
	 * ���ݳ��������Ƶ����͡��Ƶ�����ѯ�Ƶ�
	 * @param cityName
	 * @param star
	 * @param name
	 * @return
	 */
	public List listHotelBySomefactor(String cityName, String star, String name) {
		List hotelList = DBOFactory.getInstance().getDBO().listHotelBySomefactor(cityName, star, name);
		return hotelList;
	}
	
	/**
	 * ͨ���Ƶ���������ѯ�Ƶ�
	 * @param star
	 * @return
	 */
	public List listHotelByStar(String star) {
		return DBOFactory.getInstance().getDBO().listHotelByStar(star);
	}
	
	/**
	 * ���ݾƵ����Ʋ�ѯ�Ƶ�
	 * @param name
	 * @return
	 */
	public List listHotelByName(String name) {
		return DBOFactory.getInstance().getDBO().listHotelByName(name);
	}
	
	/**
	 * �����Ƶ��Ԥ����Ϣ
	 * @param hotelName
	 * @return
	 */
	public List listHotelReserveInfo(String hotelName) {
		return DBOFactory.getInstance().getDBO().listHotelReserveInfo(hotelName);
	}
	
	/**
	 * Ԥ���Ƶ귿��
	 * @param hotel
	 * @param uid
	 */
	public void reserveHotelRoom(Hotel hotel, int uid) {
		DBOFactory.getInstance().getDBO().reserveHotelRoom(hotel, uid);
	}
	
	/**
	 * �г������û�Ԥ���ľƵ���Ϣ
	 * @param uid
	 * @return
	 */
	public List listUserReservedHotelInfo(int uid) {
		return DBOFactory.getInstance().getDBO().listUserReservedHotelInfo(uid);
	}
	
	/**
	 * ���ݾƵ����Ͳ�ѯ�Ƶ�
	 * @param hotelName
	 * @param type
	 * @return
	 */
	public List listHotelBySigleType(String type) {
		return DBOFactory.getInstance().getDBO().listHotelByType(type);
	}
	
	public List listRoomByName(String hotelName) {
		return DBOFactory.getInstance().getDBO().listRoomByName(hotelName);
	}
	
	public Hotel getRoomId(Hotel hotel) {
		List hotelList1 = DBOFactory.getInstance().getDBO().listReservedInfoByHotelName(hotel);
		List hotelList2 = DBOFactory.getInstance().getDBO().listReservedInfoByRoomName(hotel);
		Hotel hotelx = new Hotel();
		Iterator it1 = hotelList1.iterator();
		while(it1.hasNext()) {
			Hotel hotel1 = (Hotel)it1.next();
			Iterator it2 = hotelList2.iterator();
			while(it2.hasNext()) {
				Hotel hotel2 = (Hotel)it2.next();
				if(hotel1.getId() == hotel2.getId()) {
					hotelx.setId(hotel2.getId());
					hotelx.setName(hotel2.getName());
					hotelx.setRoom(hotel.getRoom());
					hotelx.setReserved(hotel2.getReserved());
					
				}
			}
		}
		return hotelx;
	}
	
	public void setReservedRoom(Hotel hotel) {
		Hotel h1 = this.getRoomId(hotel);
		hotel.setId(h1.getId());
		DBOFactory.getInstance().getDBO().setReservedRoom(hotel);
	}
	
	/**
	 * �жϷ����Ƿ�Ԥ����ȡ��reserved��ֵ��0��û�б�Ԥ����1���Ѿ���Ԥ��
	 * @param hotel
	 * @return
	 */
	public int judgeRoomReserved(Hotel hotel) {
		Hotel h1 = this.getRoomId(hotel);
		hotel.setId(h1.getId());
		return DBOFactory.getInstance().getDBO().judgeRoomReserved(hotel);
		
	}
	
	/**
	 * ���¾Ƶ���Ϣ
	 * @param hotel
	 */
	public void updateHotelInfo(Hotel hotel) {
		DBOFactory.getInstance().getDBO().updateHotelInfo(hotel);
	}
	
	/**
	 * ɾ���Ƶ��¼
	 * @param hotelId
	 */
	public void deleteHotelById(int hotelId) {
		DBOFactory.getInstance().getDBO().deleteHotelById(hotelId);
	}
	
	/**
	 * ���ӾƵ���Ϣ
	 * @param hotel
	 */
	public void hotelAdd(Hotel hotel) {
		DBOFactory.getInstance().getDBO().hotelAdd(hotel);
	}
	
	/**
	 * ���ݾƵ����Ƽ��������з��䣨�����Ƿ�Ԥ����
	 * @param hotelName
	 * @return
	 */
	public List listAllRoomByName(String hotelName) {
		return DBOFactory.getInstance().getDBO().listAllRoomByName(hotelName);
	}
	
	/**
	 * ���¾Ƶ귿����Ϣ
	 * @param hotel
	 */
	public void updateHotelRoomInfo(Hotel hotel) {
		DBOFactory.getInstance().getDBO().updateHotelRoomInfo(hotel);
	}
	
	/**
	 * ����hotel���е�idɾ����
	 * @param id
	 */
	public void roomDeleteById(int id) {
		DBOFactory.getInstance().getDBO().roomDeleteById(id);
	}
	
	/**
	 * ���ӾƵ귿��
	 * @param hotel
	 */
	public void addRoom(Hotel hotel) {
		DBOFactory.getInstance().getDBO().addRoom(hotel);
	}
	
	/**
	 * ȡ���Ƶ귿���Ԥ��
	 * @param hotelId
	 */
	public void hotelCancelReserved(int hotelId) {
		DBOFactory.getInstance().getDBO().hotelCancelReserved(hotelId);
	}
	
	public List queryHotelManager(String cityName, String star, String name) {
		List hotelList = new ArrayList();
		List hotelList1 = new ArrayList();
		List hotelList2 = new ArrayList();
		List hotelList3 = new ArrayList();
		hotelList1 = null;
		hotelList2 = null;
		hotelList3 = null;
		if(cityName != "") {
			hotelList1 = this.listHotelByCityName(cityName);
		}
		if(star != "") {
			hotelList2 = this.listHotelByStar(star);
		}
		if(name != "") {
			hotelList3 = this.listHotelByName(name);
		}
		if(hotelList1 == null && hotelList2 == null && hotelList3 ==null) {
			hotelList = null;
		}
		if(hotelList1 != null && hotelList2 == null && hotelList3 ==null) {
			hotelList = hotelList1;
		}
		if(hotelList1 == null && hotelList2 != null && hotelList3 ==null) {
			hotelList = hotelList2;
		}
		if(hotelList1 == null && hotelList2 == null && hotelList3 !=null) {
			hotelList = hotelList3;
		}
		if(hotelList1 != null && hotelList2 != null && hotelList3 ==null) {
			Iterator it1 = hotelList1.iterator();
			while(it1.hasNext()) {
				Hotel hotel1 = (Hotel)it1.next();
				Iterator it2 = hotelList2.iterator();
				while(it2.hasNext()) {
					Hotel hotel2 = (Hotel)it2.next();
					if(hotel1.getId() == hotel2.getId()) {
						hotelList.add(hotel2);
					}
				}
			}
		}
		if(hotelList1 != null && hotelList2 == null && hotelList3 !=null) {
			Iterator it1 = hotelList1.iterator();
			while(it1.hasNext()) {
				Hotel hotel1 = (Hotel)it1.next();
				Iterator it3 = hotelList3.iterator();
				while(it3.hasNext()) {
					Hotel hotel3 = (Hotel)it3.next();
					if(hotel1.getId() == hotel3.getId()) {
						hotelList.add(hotel1);
					}
				}
			}
		}
		if(hotelList1 == null && hotelList2 != null && hotelList3 !=null) {
			Iterator it2 = hotelList2.iterator();
			while(it2.hasNext()) {
				Hotel hotel2 = (Hotel)it2.next();
				Iterator it3 = hotelList3.iterator();
				while(it3.hasNext()) {
					Hotel hotel3 = (Hotel)it3.next();
					if(hotel2.getId() == hotel3.getId()) {
						System.out.print("hotel2 name: " + hotel2.getName());
						System.out.println("                hotel2 name: " + hotel3.getName());
						hotelList.add(hotel3);
					}
				}
			}
		}
		if(hotelList1 != null && hotelList2 != null && hotelList3 !=null) {
			Iterator it1 = hotelList1.iterator();
			while(it1.hasNext()) {
				Hotel hotel1 = (Hotel)it1.next();
				Iterator it2 = hotelList2.iterator();
				while(it2.hasNext()) {
					Hotel hotel2 = (Hotel)it2.next();
					if(hotel1.getId() == hotel2.getId()) {
						Iterator it3 = hotelList3.iterator();
						while(it3.hasNext()) {
							Hotel hotel3 = (Hotel)it3.next();
							if(hotel2.getId() == hotel3.getId()) {
								hotelList.add(hotel2);
							}
						}
					}
				}
			}
		}
		return hotelList;
	}
	
	public Hotel queryRoomCost(int hotelId) {
		return DBOFactory.getInstance().getDBO().queryRoomCost(hotelId);
	}
}
