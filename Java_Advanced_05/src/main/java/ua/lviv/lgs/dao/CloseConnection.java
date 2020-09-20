package ua.lviv.lgs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface CloseConnection {

	public void closeConnection(Connection connection, Statement prepareStatement, ResultSet resultSet);
	
}
