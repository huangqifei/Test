package travel.struts.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import travel.struts.actions.PlaneLinkAction;
import travel.struts.data.BBS;
import travel.struts.data.DetailInfo;
import travel.struts.data.Hotel;
import travel.struts.data.Plane;
import travel.struts.data.Reply;
import travel.struts.data.Sight;
import travel.struts.data.TravelGroup;
import travel.struts.data.User;
import travel.struts.factory.DBOFactory;

public class DateBaseOperator {

	
	/**
	 * 通过ID查询酒店信息
	 * @param id
	 * @return
	 */
	public Hotel findHotelById(int id) {
		String sql = "select * from hotel_info where id=?";
		Hotel hotel = new Hotel();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hotel.setId(rs.getInt("id"));
				hotel.setName(rs.getString("name"));
				hotel.setCity(rs.getString("city"));
				hotel.setStar(rs.getString("star"));
				hotel.setInfo(rs.getString("info"));
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotel;
	}
	

	/**
	 *  通过城市来查询酒店
	 * @param cityName
	 * @return
	 */
	public List listHotelByCityName(String cityName) {
		String sql = "select * from hotel_info where city=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cityName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("id"));
				hotel.setCity(rs.getString("city"));
				hotel.setName(rs.getString("name"));
				hotel.setStar(rs.getString("star"));
				hotel.setInfo(rs.getString("info"));
				hotelList.add(hotel);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 通过酒店类型来查询酒店
	 * @param star
	 * @return
	 */
	public List listHotelByStar(String star) {
		String sql = "select * from hotel_info where star=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, star);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("id"));
				hotel.setCity(rs.getString("city"));
				hotel.setName(rs.getString("name"));
				hotel.setStar(rs.getString("star"));
				hotel.setInfo(rs.getString("info"));
				hotelList.add(hotel);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 根据酒店名称查询酒店
	 * @param name
	 * @return
	 */
	public List listHotelByName(String name) {
		String sql = "select * from hotel_info where name=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("id"));
				hotel.setCity(rs.getString("city"));
				hotel.setName(rs.getString("name"));
				hotel.setStar(rs.getString("star"));
				hotel.setInfo(rs.getString("info"));
				hotelList.add(hotel);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 列出所有酒店信息
	 * @return
	 */
	public List listHotel() {
		String sql = "select * from hotel_info";
		List hotelList = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("id"));
				hotel.setCity(rs.getString("city"));
				hotel.setName(rs.getString("name"));
				hotel.setStar(rs.getString("star"));
				String hotelInfo = rs.getString("info");
				if(hotelInfo.length()>=12) {
					hotelInfo = hotelInfo.substring(0, 12) + "...";
				}
				hotel.setInfo(hotelInfo);
				hotelList.add(hotel);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		
		return hotelList;
	}

	/**
	 * 填写酒店预订信息(未有已存在的客户订单）
	 * @param detailInfo
	 * @param hotelId
	 * @param userName
	 */
	public void fillHotelDetailedInfomation(User user, int hotelId, String userName) {
		String sql = "insert into reserve_info(username, tname, hotel_id) values(?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, user.getName());
			pstmt.setInt(3, hotelId);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 根据城市名、类型、酒店名称进行查询
	 * @param cityName
	 * @param star
	 * @param name
	 * @return
	 */
	public List listHotelBySomefactor(String cityName, String star, String name) {
		List hotelList = new ArrayList();
		int sign = 0;
		String sql = null;
		if(cityName != "") {
			sign = 100 + sign;
		}
		if(star != "") {
			sign = 10 + sign;
		}
		if(name != "") {
			sign = 1 + sign;
		}
		if(sign == 0) {
			sql = "";
		} else if(sign == 10) {
			sql = "select * from hotel_info where star=?"; 
		} else if(sign == 1) {
			sql = "select * from hotel_info where name=?";
		} else if(sign == 100) {
			sql = "select * from hotel_info where city=?";
		} else if(sign == 101) {
			sql = "select * from hotel_info where ciyt=?, name=?";
		} else if(sign == 11) {
			sql = "select * from hotel_info where star=?, name=?";
		} else if(sign == 110) {
			sql = "select * from hotel_info where city=?, star=?";
		} else if(sign == 111) {
			sql = "select * from hotel_info where city=?, star=?, name=?";
		}
		if(sql != "") {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DB.getConn();
				pstmt = conn.prepareStatement(sql);
				if(sign == 10) {
					pstmt.setString(1, star);
				} else if(sign == 1) {
					pstmt.setString(1, name);
				} else if(sign == 100) {
					pstmt.setString(1, cityName);
				} else if(sign == 101) {
					pstmt.setString(1, cityName);
					pstmt.setString(2, name);
				} else if(sign == 11) {
					pstmt.setString(1, star);
					pstmt.setString(2, name);
				} else if(sign == 110) {
					pstmt.setString(1, cityName);
					pstmt.setString(2, star);
				} else if(sign == 111) {
					pstmt.setString(1, cityName);
					pstmt.setString(2, star);
					pstmt.setString(3, name);
				}
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Hotel hotel = new Hotel();
					hotel.setId(rs.getInt("id"));
					hotel.setCity(rs.getString("city"));
					hotel.setName(rs.getString("name"));
					hotel.setStar(rs.getString("star"));
					hotel.setInfo(rs.getString("info"));
					hotelList.add(hotel);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB.closeRS(rs);
				DB.closeStmt(pstmt);
				DB.closeConn(conn);
			}
		} else {
			hotelList = null;
		}
		return hotelList;
	}
	
	/**
	 * 检索酒店的预订信息
	 * @param hotelName
	 * @return
	 */
	public List listHotelReserveInfo(String hotelName) {
		String sql = "select * from hotel where name=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setType(rs.getString("type"));
				hotel.setRoom(rs.getString("room"));
				hotel.setReserved(rs.getInt("reserved"));
				if(hotel.getReserved() == 0) {
					hotelList.add(hotel);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	public void reserveHotelRoom(Hotel hotel, int uid) {
		String sql = "insert into hotel_reserve (name, uid, year, month, day, room) values (?, ?, ?, ?, ?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt =  conn.prepareStatement(sql);
			int reserveDay = hotel.getLive_day();
			for(int i=1; i<=reserveDay; i++) {
				pstmt.setString(1, hotel.getName());
				pstmt.setInt(2, uid);
				pstmt.setInt(3, hotel.getYear());
				if(hotel.getMonth() == 2) {
					int day = hotel.getDay();
					day = day + i;
					if(day < 28) {
						pstmt.setInt(4, hotel.getMonth());
						pstmt.setInt(5, day);
					} else {								//如果是二月则月+1,天数-28
						int month = hotel.getMonth() + 1;
						day = day - 28;
						pstmt.setInt(4, month);
						pstmt.setInt(5, day);
					}
				} else {
					int day = hotel.getDay();
					day = day + i;
					pstmt.setInt(4, hotel.getMonth());
					pstmt.setInt(5, day);
				}
				pstmt.setString(6, hotel.getRoom());
				pstmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 在Hotel表中根据酒店名称查询该酒店的所有信息，为设置房间是否预订做准备。
	 * @param hotel
	 * @return
	 */
	public List listReservedInfoByHotelName(Hotel hotel) {
		String sql = "select * from hotel where name=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotel.getName());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel h = new Hotel();
				h.setId(rs.getInt("id"));
				h.setName(rs.getString("name"));
				h.setRoom(rs.getString("room"));
				hotelList.add(h);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 在Hotel表中根据房间名称查询有该房间酒店的所有信息，为设置房间是否预订做准备。
	 * @param hotel
	 * @return
	 */
	public List listReservedInfoByRoomName(Hotel hotel) {
		String sql = "select * from hotel where room=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotel.getRoom());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel h = new Hotel();
				h.setId(rs.getInt("id"));
				h.setName(rs.getString("name"));
				h.setRoom(rs.getString("room"));
				hotelList.add(h);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 
	 * @param hotel
	 */
	public void setReservedRoom(Hotel hotel) {
		String sql = "update hotel set reserved=1 where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotel.getId());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 判断房间是否预订，取出reserved的值。0：没有被预订，1：已经被预订
	 * @param hotel
	 * @return
	 */
	public int judgeRoomReserved(Hotel hotel) {
		Hotel hotel1 = new Hotel();
		String sql = "select * from hotel where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotel.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hotel1.setReserved(rs.getInt("reserved"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotel1.getReserved();
	}
	
	/**
	 * 列出所有用户预订的酒店信息
	 * @param uid
	 * @return
	 */
	public List listUserReservedHotelInfo(int uid) {
		String sql = "select * from hotel_reserve where uid=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("id"));
				hotel.setName(rs.getString("name"));
				hotel.setYear(rs.getInt("year"));
				hotel.setMonth(rs.getInt("month"));
				hotel.setDay(rs.getInt("day"));
				hotel.setRoom(rs.getString("room"));
				hotelList.add(hotel);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 通过酒店房型查询酒店
	 * @param hotelName
	 * @param type
	 * @return
	 */
	public List listHotelByType(String type) {
		String sql = "select * from hotel where type=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setName(rs.getString("name"));
				hotel.setRoom(rs.getString("Room"));
				hotel.setType(rs.getString("type"));
				hotel.setReserved(rs.getInt("reserved"));
				if(hotel.getReserved() == 0) {
					hotelList.add(hotel);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 根据酒店名称检索出没有被预订的房间
	 * @param hotelName
	 * @return
	 */
	public List listRoomByName(String hotelName) {
		String sql = "select * from hotel where name=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("id"));
				hotel.setName(rs.getString("name"));
				hotel.setRoom(rs.getString("Room"));
				hotel.setType(rs.getString("type"));
				hotel.setReserved(rs.getInt("reserved"));
				if(hotel.getReserved() == 0) {
					hotelList.add(hotel);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 根据酒店名称检索出所有房间（不管是否预订）
	 * @param hotelName
	 * @return
	 */
	public List listAllRoomByName(String hotelName) {
		String sql = "select * from hotel where name=?";
		List hotelList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotelName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("id"));
				hotel.setName(rs.getString("name"));
				hotel.setRoom(rs.getString("Room"));
				hotel.setType(rs.getString("type"));
				hotel.setCost(rs.getInt("cost"));
				hotel.setReserved(rs.getInt("reserved"));
				hotelList.add(hotel);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotelList;
	}
	
	/**
	 * 更新酒店信息
	 * @param hotel
	 */
	public void updateHotelInfo(Hotel hotel) {
		String sql = "update hotel_info set name=?,city=?,star=?,info=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotel.getName());
			pstmt.setString(2, hotel.getCity());
			pstmt.setString(3, hotel.getStar());
			pstmt.setString(4, hotel.getInfo());
			pstmt.setInt(5, hotel.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 删除酒店记录
	 * @param hotelId
	 */
	public void deleteHotelById(int hotelId) {
		String sql = "delete from hotel_info where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 增加酒店信息
	 * @param hotel
	 */
	public void hotelAdd(Hotel hotel) {
		String sql = "insert into hotel_info(name, city, star, info) values(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotel.getName());
			pstmt.setString(2, hotel.getCity());
			pstmt.setString(3, hotel.getStar());
			pstmt.setString(4, hotel.getInfo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 更新酒店房间信息
	 * @param hotel
	 */
	public void updateHotelRoomInfo(Hotel hotel) {
		String sql = "update hotel set name=?,type=?,room=?,cost=?,reserved=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotel.getName());
			pstmt.setString(2, hotel.getType());
			pstmt.setString(3, hotel.getRoom());
			pstmt.setInt(4, hotel.getCost());
			pstmt.setInt(5, hotel.getReserved());
			pstmt.setInt(6, hotel.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 根据hotel表中的id删数据
	 * @param id
	 */
	public void roomDeleteById(int id) {
		String sql = "delete from hotel where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 增加酒店房间
	 * @param hotel
	 */
	public void addRoom(Hotel hotel) {
		String sql = "insert into hotel(name, type, room, cost, reserved) values(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hotel.getName());
			pstmt.setString(2, hotel.getType());
			pstmt.setString(3, hotel.getRoom());
			pstmt.setInt(4, hotel.getCost());
			pstmt.setInt(5, hotel.getReserved());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 取消酒店房间的预订
	 * @param hotelId
	 */
	public void hotelCancelReserved(int hotelId) {
		String sql = "delete from hotel_reserve where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public Hotel queryRoomCost(int hotelId) {
		Hotel hotel = new Hotel();
		String sql = "select * from hotel where hotelId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hotelId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hotel.setId(rs.getInt("id"));
				hotel.setName(rs.getString("name"));
				hotel.setRoom(rs.getString("Room"));
				hotel.setType(rs.getString("type"));
				hotel.setCost(rs.getInt("cost"));
				hotel.setReserved(rs.getInt("reserved"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hotel;
	}
	
	
	
	/*
	 * 机票预订模块
	 * --------------------------------------------------------------------------------------------------------
	 */

	/**
	 *列出所有航班信息 
	 *
	 * @return
	 */
	public List listPlaneInfo() {
		String sql = "select * from plane_info";
		List planeList = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Plane plane = new Plane();
				plane.setId(rs.getInt("id"));
				plane.setNumber(rs.getString("number"));
				plane.setFromcity(rs.getString("fromcity"));
				plane.setDestination(rs.getString("destination"));
				plane.setFly_time(rs.getString("fly_time"));
				plane.setArrive_time(rs.getString("arrive_time"));
				plane.setHaspeople(rs.getInt("haspeople"));
				plane.setMaxpeople(rs.getInt("maxpeople"));
				plane.setFee(rs.getInt("fee"));
				planeList.add(plane);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		return planeList;
	}
	
	/**
	 * 通过ID查询航班信息
	 * @param id
	 * @return
	 */
	public Plane findPlaneById(int id) {
		String sql = "select * from plane_info where id=?";
		Plane plane = new Plane();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				plane.setId(rs.getInt("id"));
				plane.setNumber(rs.getString("number"));
				plane.setFromcity(rs.getString("fromcity"));
				plane.setDestination(rs.getString("destination"));
				plane.setFly_time(rs.getString("fly_time"));
				plane.setArrive_time(rs.getString("arrive_time"));
				plane.setHaspeople(rs.getInt("haspeople"));
				plane.setMaxpeople(rs.getInt("maxpeople"));
				plane.setFee(rs.getInt("fee"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
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
		String sql = "select * from reserve_info where username=?";
		String username = null;
		int plane_id = 0;
		boolean sign = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				username = rs.getString("username");
				plane_id = rs.getInt("plane_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		if(username != null) {
			if(plane_id == 0) {
				return 1;		//已经有了该用户的订单，且该用户没有预订任何航班。
			} else {
				return 2;		//已经有了该用户的订单，且该用户已经预订了航班。
			}
		} else {
			return 3; 			//该用户还没有任何预订信息。
		}
	}
	
	/**
	 * 填写航班预订信息(未有已存在的客户订单）
	 * @param detailInfo
	 * @param hotelId
	 * @param userName
	 */
	public void fillPlaneDetailedInfomation(User user, int planeId) {
		String sql = "insert into reserve_info(username, tname, plane_id) values(?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getTname());
			pstmt.setInt(3, planeId);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	

	/**
	 * 根据航班号列出航班信息
	 * @param number
	 * @return
	 */
	public List listPlaneByNumber(String number) {
		String sql = "select * from plane_info where number=?";
		List planeList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Plane plane = new Plane();
				plane.setId(rs.getInt("id"));
				plane.setArrive_time(rs.getString("arrive_time"));
				plane.setDestination(rs.getString("destination"));
				plane.setFee(rs.getInt("fee"));
				plane.setFly_time(rs.getString("fly_time"));
				plane.setFromcity(rs.getString("fromcity"));
				plane.setNumber(rs.getString("number"));
				planeList.add(plane);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return planeList;
	}
	
	/**
	 * 根据出发地查询航班
	 * @param from
	 * @return
	 */
	public List listPlaneByFrom(String fromcity) {
		String sql = "select * from plane_info where fromcity=?";
		List planeList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fromcity);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Plane plane = new Plane();
				plane.setId(rs.getInt("id"));
				plane.setArrive_time(rs.getString("arrive_time"));
				plane.setDestination(rs.getString("destination"));
				plane.setFee(rs.getInt("fee"));
				plane.setFly_time(rs.getString("fly_time"));
				plane.setFromcity(rs.getString("fromcity"));
				plane.setNumber(rs.getString("number"));
				planeList.add(plane);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return planeList;
	}
	
	/**
	 * 更新己预订航班人数
	 * @param planeId
	 * @param hasPeople
	 */
	public void updatePlaneDetailedInfomation(int planeId, int hasPeople) {
		String sql = "update plane_info set haspeople=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hasPeople);
			pstmt.setInt(2, planeId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 更新用户预订航班的信息
	 * @param planeId
	 * @param fly_type
	 * @param userId
	 * @param reservedPeople
	 */
	public void updateUserReservePlaneInfo(Plane plane, String fly_type, int userId, int reservedPeople) {
		String sql = "insert into plane_reserve(number, fromcity, destination, uid, fly_time, arrive_time, fly_type, reservedpeople) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plane.getNumber());
			pstmt.setString(2, plane.getFromcity());
			pstmt.setString(3, plane.getDestination());
			pstmt.setInt(4, userId);
			pstmt.setString(5, plane.getFly_time());
			pstmt.setString(6, plane.getArrive_time());
			pstmt.setString(7, fly_type);
			pstmt.setInt(8, reservedPeople);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}

	/**
	 * 列出用户预订航班信息
	 * @param userId
	 * @return
	 */
	public List listUserReservedPlaneInfo(int userId) {
		List planeList = new ArrayList();
		String sql = "select * from plane_reserve where uid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Plane plane = new Plane();
				plane.setId(rs.getInt("id"));
				plane.setNumber(rs.getString("number"));
				plane.setFromcity(rs.getString("fromcity"));
				plane.setDestination(rs.getString("destination"));
				plane.setFly_time(rs.getString("fly_time"));
				plane.setArrive_time(rs.getString("arrive_time"));
				plane.setFly_type(rs.getString("fly_type"));
				plane.setReservedPeople(rs.getInt("reservedPeople"));
				planeList.add(plane);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return planeList;
	}
	
	/**
	 * 更新航班信息（管理员修改页面）
	 * @param plane
	 */
	public void updatePlaneInfo(Plane plane) {
		String sql = "update plane_info set number=?,fromcity=?,destination=?,fly_time=?,arrive_time=?,haspeople=?,maxpeople=?,fee=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plane.getNumber());
			pstmt.setString(2, plane.getFromcity());
			pstmt.setString(3, plane.getDestination());
			pstmt.setString(4, plane.getFly_time());
			pstmt.setString(5, plane.getArrive_time());
			pstmt.setInt(6, plane.getHaspeople());
			pstmt.setInt(7, plane.getMaxpeople());
			pstmt.setInt(8, plane.getFee());
			pstmt.setInt(9, plane.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 根据ID删除航班信息
	 * @param planeId
	 */
	public void deletePlaneById(int planeId) {
		String sql = "delete from plane_info where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planeId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 增加航班信息（管理员）
	 * @param plane
	 */
	public void planeAdd(Plane plane) {
		String sql = "insert into plane_info(number, fromcity, destination, fly_time, arrive_time, haspeople, maxpeople, fee) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plane.getNumber());
			pstmt.setString(2, plane.getFromcity());
			pstmt.setString(3, plane.getDestination());
			pstmt.setString(4, plane.getFly_time());
			pstmt.setString(5, plane.getArrive_time());
			pstmt.setInt(6, plane.getHaspeople());
			pstmt.setInt(7, plane.getMaxpeople());
			pstmt.setInt(8, plane.getFee());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public Plane findPlaneByIdInPlane(int id) {
		String sql = "select * from plane_reserve where id=?";
		Plane plane = new Plane();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				plane.setId(rs.getInt("id"));
				plane.setNumber(rs.getString("number"));
				plane.setFromcity(rs.getString("fromcity"));
				plane.setDestination(rs.getString("destination"));
				plane.setFly_time(rs.getString("fly_time"));
				plane.setReservedPeople(rs.getInt("reservedpeople"));
				plane.setArrive_time(rs.getString("arrive_time"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return plane;
	}
	
	public void planeEnsurePeople(Plane plane) {
		String sql = "update plane_info set haspeople=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, plane.getHaspeople());
			pstmt.setInt(2, plane.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public Plane findPlaneByNumber(String number) {
		String sql = "select * from plane_info where number=?";
		Plane plane = new Plane();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				plane.setId(rs.getInt("id"));
				plane.setNumber(rs.getString("number"));
				plane.setFromcity(rs.getString("fromcity"));
				plane.setDestination(rs.getString("destination"));
				plane.setFly_time(rs.getString("fly_time"));
				plane.setHaspeople(rs.getInt("hasPeople"));
				plane.setArrive_time(rs.getString("arrive_time"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return plane;
	}
	
	/*
	 *------------------------------------------------------------------------------------------------------------
	 * 论坛模块
	 * 
	 */
	
	public List bbsList() {
		String sql = "select * from bbs";
		List bbsList = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BBS bbs = new BBS();
				bbs.setId(rs.getInt("id"));
				bbs.setName(rs.getString("name"));
				bbs.setContent(rs.getString("content"));
				bbs.setDate(rs.getString("date"));
				bbs.setAccess(rs.getInt("access"));
				bbs.setReply(rs.getInt("reply"));
				bbs.setUid(rs.getInt("uid"));
				bbsList.add(bbs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		return bbsList;
	}
	
	public BBS findPostById(int postId) {
		String sql = "select * from bbs where id=?";
		BBS post = new BBS();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				post.setId(rs.getInt("id"));
				post.setName(rs.getString("name"));
				post.setContent(rs.getString("content"));
				post.setDate(rs.getString("date"));
				post.setAccess(rs.getInt("access"));
				post.setReply(rs.getInt("reply"));
				post.setUid(rs.getInt("uid"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return post;
	}
	
	public List<Reply> listReplyByPostId(int postId) {
		String sql = "select * from reply where postId=?";
		List replyList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setId(rs.getInt("id"));
				reply.setPostId(rs.getInt("postId"));
				reply.setUid(rs.getInt("uid"));
				User user = this.findUserById(reply.getUid());
				reply.setUsername(user.getName());
				reply.setContent(rs.getString("content"));
				reply.setDate(rs.getString("date"));
				reply.setRid(rs.getInt("rid"));
				replyList.add(reply);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return replyList;
	}
	
	/**
	 * 回帖
	 * @param postId
	 * @param userId
	 * @param bbs
	 */
	public void addPostReply(int postId, int userId, BBS bbs) {
		String sql = "insert into reply(postId, uid, content, date, rid) values(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			pstmt.setInt(2, userId);
			pstmt.setString(3, bbs.getContent());
			pstmt.setString(4, bbs.getDate());
			pstmt.setInt(5, bbs.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public void addAccess(int postId) {
		String sql = "update bbs set access=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			BBS bbs = this.findPostById(postId);
			bbs.setAccess(bbs.getAccess() + 1);
			pstmt.setInt(1, bbs.getAccess());
			pstmt.setInt(2, postId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public void addReply(int postId) {
		String sql = "update bbs set reply=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			BBS bbs = this.findPostById(postId);
			bbs.setReply(bbs.getReply() + 1);
			pstmt.setInt(1, bbs.getReply());
			pstmt.setInt(2, postId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public void appearPost(BBS bbs) {
		String sql = "insert into bbs(name, content, date, access, reply, uid) values(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbs.getName());
			pstmt.setString(2, bbs.getContent());
			pstmt.setString(3, bbs.getDate());
			pstmt.setInt(4, bbs.getAccess());
			pstmt.setInt(5, bbs.getReply());
			pstmt.setInt(6, bbs.getUid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 删贴
	 * @param postId
	 */
	public void deletePostById(int postId) {
		String sql = "delete from bbs where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public void deleteReplyByid(int replyId) {
		String sql = "delete from reply where rid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/*
	 * 用户管理模块
	 * -----------------------------------------------------------------------------------------------------
	 */
	/**
	 * 
	 * 登陆时用户查询
	 * @param user
	 * @return
	 */
	public User findUserByName(User user) {
		String userName = user.getName();
		User user1 = new User();
		String sql = "select * from user_info where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user1.setId(rs.getInt("user_id"));
				user1.setName(rs.getString("name"));
				user1.setPassword(rs.getString("password"));
				user1.setTname(rs.getString("tname"));
				user1.setTelephone(rs.getString("telephone"));
				user1.setAdmin(rs.getBoolean("admin"));
				user1.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		
		return user1;
	}
	
	
	/**
	 * 游客添加模块
	 */
	public void userAdd(User user) {
		String sql = "insert into user_info(name, tname, password, telephone, email) values(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getTname());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getTelephone());
			pstmt.setString(5, user.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 管理员、用户密码修改模块（其它修改以后增加）只能修改不能修改用户名及权限
	 * @param user
	 */
	public void UserModify(User user) {
		String sql = "update user_info set password=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 修改游客个人信息
	 * @param user
	 */
	public void modifyUserInfo(User user) {
		String sql = "update user_info set name=?, tname=? where user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getTname());
			pstmt.setInt(3, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}

	/**
	 * 用户删除（其它修改以后增加）只能修改不能修改用户名及权限  nameInfo: 要删除的用户名集
	 * @param nameInfo
	 */
	public void userDelete(String nameInfo) {
		String sql = "delete from t_user where name in (" + nameInfo + ")";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DB.getConn();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
	}

	/**
	 * 查询游客帐号，为删除游客做准备
	 * @return
	 */
	public List touristQuery() {
		String sql = "select * from plane_info where admin=?";
		List touristList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, true);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				touristList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return touristList;
	}
	
	public void planeCancelReserved(int planeId) {
		String sql = "delete from plane_reserve where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planeId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public User findUserById(int userId) {
		User user = new User();
		String sql = "select * from user_info where user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		
		return user;
	}
	
	/**
	 * 判断用户是否存在...返回true说明不存在,false说明存在
	 * @param user
	 * @return
	 */
	public boolean isUserExist(User user) {
		boolean sign = true;
		String sql = "select * from user_info where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sign = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return sign;
	}

	
	/*
	 * 景点模块
	 * --------------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * 列出所有景点名称
	 */
	public List listSightName() {
		String sql = "select * from sight_info";
		List sightList = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Sight sight = new Sight();
				sight.setId(rs.getInt("id"));
				sight.setName(rs.getString("name"));
				sight.setCity(rs.getString("city"));
				sight.setTicket_cost(rs.getInt("ticket_cost"));
				String sightInfo = rs.getString("info");
				if(sightInfo.length()>=12) {
					sightInfo = sightInfo.substring(0, 12) + "...";
				}
				sight.setInfo(sightInfo);
				sightList.add(sight);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		return sightList;
	}
	
	/**
	 * 根据条件列出景点
	 * @param name
	 * @param value
	 * @return
	 */
	public List querySight(String name, String value) {
		String sql = null;
		//根据传来的数据确定查询语句
		if(name.equals("city")) {
			sql = "select * from sight_info where city=?";
		} else if(name.equals("name")){
			sql = "select * from sight_info where name=?";
		} else if(name.equals("group_id")) {
			sql = "select * from sight_info where group_id=?";
		}
		
		List sightlList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			if(name.equals("group_id")) {
				int group_id = Integer.parseInt(value);
				pstmt.setInt(1, group_id);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sight sight = new Sight();
				sight.setCity(rs.getString("city"));
				sight.setName(rs.getString("name"));
				sight.setGroup_id(rs.getInt("group_id"));
				sight.setTicket_cost(rs.getInt("ticket_cost"));
				sight.setInfo(rs.getString("info"));
				sightlList.add(sight);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		
		return sightlList;
	}
	
	/**
	 * 根据Id查询景点
	 * @param id
	 * @return Sight
	 */
	public Sight findSightById(int id) {
		String sql = "select * from sight_info where id=?";
		Sight sight = new Sight();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sight.setId(rs.getInt("id"));
				sight.setCity(rs.getString("city"));
				sight.setName(rs.getString("name"));
				sight.setTicket_cost(rs.getInt("ticket_cost"));
				sight.setDiscount(rs.getInt("discount"));
				sight.setInfo(rs.getString("info"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return sight;
	}
	
	/**
	 * 根据该景点列出所有旅游团信息
	 * @param sightName
	 * @return
	 */
	public List listGroupBySightName(String sightName) {
		String sql = "select * from group_info where sight=?";
		List groupList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sightName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TravelGroup tg = new TravelGroup();
				tg.setId(rs.getInt("id"));
				tg.setName(rs.getString("name"));
				groupList.add(tg);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return groupList;
	}
	
	/**
	 * 根据城市名查询该城市的景点
	 * @param cityName
	 * @return
	 */
	public List listSightByCityName(String cityName) {
		String sql = "select * from sight_info where city=?";
		List sightList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cityName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sight sight = new Sight();
				sight.setId(rs.getInt("id"));
				sight.setName(rs.getString("name"));
				sight.setCity(rs.getString("city"));
				sight.setTicket_cost(rs.getInt("ticket_cost"));
				sight.setDiscount(rs.getInt("discount"));
				String sightInfo = rs.getString("info");
				if(sightInfo.length()>=12) {
					sightInfo = sightInfo.substring(0, 12) + "...";
				}
				sight.setInfo(sightInfo);
				sightList.add(sight);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return sightList;
	}
	
	/**
	 * 通过旅游团ID查询旅游团信息
	 * @param groupId
	 * @return
	 */
	public TravelGroup findGroupByid(int groupId) {
		String sql = "select * from group_info where id=?";
		TravelGroup group = new TravelGroup();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				group.setId(rs.getInt("id"));
				group.setSight(rs.getString("sight"));
				group.setName(rs.getString("name"));
				group.setCost(rs.getInt("cost"));
				group.setMaxpeople(rs.getInt("maxpeople"));
				group.setHaspeople(rs.getInt("haspeople"));
				group.setInfo(rs.getString("info"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return group;
	}
	
	/**
	 * 通过旅游团ID查询该旅游团去的景点
	 * @param groupId
	 * @return
	 */
	public List listSightByGroupId(int groupId) {
		List sightList = new ArrayList();
		String sql = "select * from sight_info where group_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sight sight = new Sight();
				sight.setId(rs.getInt("id"));
				sight.setName(rs.getString("name"));
				sight.setCity(rs.getString("city"));
				sight.setGroup_id(rs.getInt("group_id"));
				sight.setTicket_cost(rs.getInt("ticket_cost"));
				sight.setDiscount(rs.getInt("discount"));
				sight.setInfo(rs.getString("info"));
				sightList.add(sight);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return sightList;
	}
	
	/**
	 * 判断该用户是否有预订东东
	 * @param userName 网站的用户名（不是真实姓名）
	 * @return 1：已经有了该用户的订单，且该用户没有预订任何旅行团。
	 * 		   2：已经有了该用户的订单，且该用户已经预订了旅行团。
	 * 		   3：该用户还没有任何预订信息。
	 */
	public int queryHasGroupReserveInfo(String userName) {
		String sql = "select * from reserve_info where userName=?";
		String username = null;
		int hotel_id = 0;
		boolean sign = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				username = rs.getString("username");
				hotel_id = rs.getInt("group_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		if(username != null) {
			if(hotel_id == 0) {
				return 1;		//已经有了该用户的订单，且该用户没有预订任何旅行团。
			} else {
				return 2;		//已经有了该用户的订单，且该用户已经预订了旅行团。
			}
		} else {
			return 3; 			//该用户还没有任何预订信息。
		}
	}
	
	/**
	 * 填写旅游团预订信息(未有已存在的客户订单）
	 * @param detailInfo
	 * @param hotelId
	 * @param userName
	 */
	public void fillGroupDetailedInfomation(DetailInfo detailInfo, int groupId, String userName) {
		String sql = "insert into reserve_info(username, tname, telephone, email, group_id) values(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, detailInfo.getName());
			pstmt.setString(3, detailInfo.getTelephone());
			pstmt.setString(4, detailInfo.getEmail());
			pstmt.setInt(5, groupId);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 如果已有该客户的其他订单则只更新它的旅游团预订信息。
	 * @param hotelId
	 */
	public void updateGroupDetailedInfomation(int grouplId) {
		String sql = "update reserve_info set group_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, grouplId);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}

	public List listSightBySightName(String sightName) {
		List sightList = new ArrayList();
		String sql = "select * from sight_info where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sightName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sight sight = new Sight();
				sight.setCity(rs.getString("city"));
				sight.setName(rs.getString("name"));
				sight.setDiscount(rs.getInt("discount"));
				sight.setInfo(rs.getString("info"));
				sight.setTicket_cost(rs.getInt("ticket_cost"));
				sight.setId(rs.getInt("id"));
				sightList.add(sight);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return sightList;
	}
	
	public List listSightBySightCityName(String cityName,String sightName) {
		List sightList = new ArrayList();
		String sql = "select * from sight_info where name=?, city=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sightName);
			pstmt.setString(2, cityName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sight sight = new Sight();
				sight.setCity(rs.getString("city"));
				sight.setName(rs.getString("name"));
				sight.setDiscount(rs.getInt("discount"));
				sight.setGroup_id(rs.getInt("group_id"));
				sight.setInfo(rs.getString("info"));
				sight.setTicket_cost(rs.getInt("ticket_cost"));
				sight.setId(rs.getInt("id"));
				sightList.add(sight);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return sightList;
	}
	
	/**
	 * 根据旅游团ID查询已有人数
	 * @param groupId
	 * @return
	 */
	public int findHasReservedPeopleByGroupId(int groupId) {
		int hasPeople = 0;
		String sql = "select * from group_info where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hasPeople = rs.getInt("haspeople");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return hasPeople;
	}
	
	/**
	 * 更新group_info表，更新已有人数
	 * @param groupId
	 * @param hasPeople
	 */
	public void reserveGroup(int groupId, int hasPeople) {
		String sql = "update group_info set haspeople=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hasPeople);
			pstmt.setInt(2, groupId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}

	/**
	 * 更新预订信息，表group_reserve;
	 * @param group
	 * @param userId
	 * @param reservepeople
	 */
	public void updateGroupReserved(TravelGroup group, int userId, int reservepeople) {
		String sql = "insert into group_reserve(sight, name, uid, reservedpeople) values(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, group.getSight());
			pstmt.setString(2, group.getName());
			pstmt.setInt(3, userId);
			pstmt.setInt(4, reservepeople);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 列出游客预订的信息
	 * @param userId
	 * @return
	 */
	public List listUserReservedGroupInfo(int userId) {
		List groupList = new ArrayList();
		String sql = "select * from group_reserve where uid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TravelGroup group = new TravelGroup();
				group.setId(rs.getInt("id"));
				group.setSight(rs.getString("sight"));
				group.setName(rs.getString("name"));
				group.setReservepeople(rs.getInt("reservedpeople"));
				groupList.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return groupList;
	}
	
	public List listSightByGroupName(String groupName) {
		List sightList = new ArrayList();
		String sql = "select * from group_info where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sight sight = new Sight();
				sight.setName(rs.getString("sight"));
				sightList.add(sight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return sightList;
	}
	
	public Sight findSightIdBySightName(String sightName) {
		String sql = "select * from sight_info where name=?";
		Sight sight = new Sight();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sightName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sight.setId(rs.getInt("id"));
				sight.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return sight;
	}
	
	/**
	 * 更新景点信息
	 * @param sight
	 */
	public void updateSightInfo(Sight sight) {
		String sql = "update sight_info set name=?,city=?,ticket_cost=?,discount=?,info=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sight.getName());
			pstmt.setString(2, sight.getCity());
			pstmt.setInt(3, sight.getTicket_cost());
			pstmt.setInt(4, sight.getDiscount());
			pstmt.setString(5, sight.getInfo());
			pstmt.setInt(6, sight.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 根据景点ID删除景点信息
	 * @param sightId
	 */
	public void deleteSightById(int sightId) {
		String sql = "delete from sight_info where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sightId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 增加景点信息
	 * @param sight
	 */
	public void sightAdd(Sight sight) {
		String sql = "insert into sight_info(name, city, ticket_cost, discount, info) values(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sight.getName());
			pstmt.setString(2, sight.getCity());
			pstmt.setInt(3, sight.getTicket_cost());
			pstmt.setInt(4, sight.getDiscount());
			pstmt.setString(5, sight.getInfo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 只取出景点城市的名称,为首页所用.
	 * @return
	 */
	public List listCityNameForIndex() {
		String sql = "select * from sight_info";
		String cityName = "ssss";
		String city = null;
		List sightNameList = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			 
			while(rs.next()) {
				Sight sight = new Sight();
				sight.setCity(rs.getString("city"));
				sight.setId(rs.getInt("id"));
				city = sight.getCity();
				if(!city.equals(cityName)) {
					cityName = city;
					sightNameList.add(sight);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		return sightNameList;
	}
	
	/**
	 * 取消旅游团预订信息
	 * @param groupId
	 */
	public void groupCancelReserved(int groupId) {
		String sql = "delete from group_reserve where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, groupId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}


	//get reply list
	public List listReply() {
		String sql = "select * from reply ";
		List replyList = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setId(rs.getInt("id"));
				reply.setPostId(rs.getInt("postId"));
				reply.setUid(rs.getInt("uid"));
				User user = this.findUserById(reply.getUid());
				reply.setUsername(user.getName());
				reply.setContent(rs.getString("content"));
				reply.setDate(rs.getString("date"));
				reply.setRid(rs.getInt("rid"));
				replyList.add(reply);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRS(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return replyList;
	}

}
