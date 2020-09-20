package ua.lviv.lgs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConnectionUtils {

	private static String url = "jdbc:mysql://localhost:3306/my_store";
	private static String user = "root";
	private static String password = "123321";
	
	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	public static LocalDateTime parseToLocalDateTime(String date) {
		
		StringBuilder dateBuilder = new StringBuilder(date);
		dateBuilder.replace(10, 11,"T");
		LocalDateTime localDateTime = LocalDateTime.parse(dateBuilder.toString());
		
		return localDateTime;
	}
	
	public static String parseToMsqlString(LocalDateTime date) {
		
		StringBuilder stringBuilder = new StringBuilder(date.toString());
		stringBuilder.replace(10, 11, " ");
		String string = stringBuilder.toString();		
		
		return string;
	}
	
}
