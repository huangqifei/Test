package travel.struts.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	public static Connection getConn() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/travel";
			String username = "root";
			String password = "root";		
			conn=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConn(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
				conn = null;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStmt(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeRS(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
				rs = null;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
