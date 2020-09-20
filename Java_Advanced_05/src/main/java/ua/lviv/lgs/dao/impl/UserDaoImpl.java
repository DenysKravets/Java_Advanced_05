package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private String READ_ALL = "select * from user";
	private String READ = "select * from user where id = ?";
	private String SAVE = "insert into user(firstName, lastName, email, role)"
			+ " values (?, ?, ?, ?)";
	private String DELETE = "delete from user where id = ?";
	private String UPDATE = "update user set"
			+ " firstName = ?, lastName = ?, email = ?, role = ?  where id = ?";
	
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
				
				users.add(new User(id, firstName, lastName, email, role));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
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
				
				user = new User(id, firstName, lastName, email, role);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
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
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
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
			// TODO: handle exception
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
			preparedStatement.setInt(5, user.getId());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
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
			e.printStackTrace();
		}
	}

	

	
	
}
