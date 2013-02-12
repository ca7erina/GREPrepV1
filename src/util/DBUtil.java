package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Administrator
 *
 */
public class DBUtil {
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://66.175.211.5:3306/cxx" +
					"?useUnicode=true&characterEncoding=utf8",
					"root","123456");
		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	
	public static void close(Connection conn) throws Exception{
		if(conn !=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());

	}

}
