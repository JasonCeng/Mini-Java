package cn.jason.gjp.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/gjp";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "yourpassword";

	private static BasicDataSource dataSource = new BasicDataSource();

	static {
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

}
