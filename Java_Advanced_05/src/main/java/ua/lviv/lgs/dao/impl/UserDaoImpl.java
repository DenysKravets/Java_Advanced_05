package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {

//	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	private static Logger LOGGER = LogManager.getLogger();
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private String READ_ALL = "select * from user";
	private String READ = "select * from user where id = ?";
	private String SAVE = "insert into user(firstName, lastName, email, role, password)"
			+ " values (?, ?, ?, ?, ?)";
	private String DELETE = "delete from user where id = ?";
	private String UPDATE = "update user set"
			+ " firstName = ?, lastName = ?, email = ?, role = ?, password = ?  where id = ?";
	private String READ_BY_EMAIL = "select * from user where email = ?";
	
	public UserDaoImpl() {
		super();
	}

	@Override
	public List<User> readAll() {
		
		List<User> users = new ArrayList<>();
		
		try {
			
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(READ_ALL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String email = resultSet.getString("email");
				String role = resultSet.getString("role");
				String password = resultSet.getString("password");
				
				users.add(new User(id, firstName, lastName, email, role, password));
			}
			
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return users;
	}

	@Override
	public User read(Integer searchId) {

		User user = null;
		
		try {
			
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(READ);
			preparedStatement.setInt(1, searchId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String email = resultSet.getString("email");
				String role = resultSet.getString("role");
				String password = resultSet.getString("password");
				
				user = new User(id, firstName, lastName, email, role, password);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return user;
	}
	
	@Override
	public void save(User user) {
		
		try {
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(SAVE);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmaill());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
	}

	@Override
	public void delete(Integer id) {
		
		try {
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
	}

	@Override
	public void update(User user) {

		try {
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(UPDATE);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmaill());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setInt(6, user.getId());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
	}
	
	@Override
	public User readUserByEmail(String searchEmail) {
		
		User user = null;
		
		try {
			
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, searchEmail);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String email = resultSet.getString("email");
				String role = resultSet.getString("role");
				String password = resultSet.getString("password");
				
				user = new User(id, firstName, lastName, email, role, password);
				
			}
			
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return user;
	}

	@Override
	public void closeConnection(Connection connection, Statement preparedStatement, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}


	

	
	
}
