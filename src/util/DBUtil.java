package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static String dbType="mysql";
	static String ip="127.0.0.1:3306";
	static String dbName="myhutubill";
	static String charset="UTF-8";
	static String userName="root";
	static String password="admin";
	
	
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String str=String.format("jdbc:%s://%s/%s?characterEncoding=%s", dbType,ip,dbName,charset);
		return DriverManager.getConnection(str, userName, password);
	}
	
	
}
