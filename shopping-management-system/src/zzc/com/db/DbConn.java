package zzc.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接mysql数据库
 * 
 * @author Jason Ceng
 * @date 2019年2月13日
 *
 */
public final class DbConn {
	public static Connection getconn() {
		Connection conn = null;

		String user = "root";
		String passwd = "yourpassword";
		String url = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf8&useSSL=true";

		// 已加载完驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
