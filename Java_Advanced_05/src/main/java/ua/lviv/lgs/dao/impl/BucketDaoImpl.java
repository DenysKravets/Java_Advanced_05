package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao {

//	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	private static Logger LOGGER = LogManager.getLogger();
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private String READ_ALL = "select * from bucket";
	private String READ = "select * from bucket where id = ?";
	private String SAVE = "insert into bucket(user_id, product_id, dateOfPurchase)"
			+ " values (?, ?, ?)";
	private String DELETE = "delete from bucket where id = ?";
	private String UPDATE = "update bucket set user_id = ?, product_id = ?, dateOfPurchase = ? where id = ?";
	
	public BucketDaoImpl() {
		super();
	}

	@Override
	public List<Bucket> readAll() {
		
		List<Bucket> buckets = new ArrayList<>();
		
		try {
			
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(READ_ALL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				Integer user_id = resultSet.getInt("user_id");
				Integer product_id = resultSet.getInt("product_id");
				LocalDateTime dateOfPurchase = ConnectionUtils.parseToLocalDateTime(resultSet.getString("dateOfPurchase"));
				
				buckets.add(new Bucket(id, user_id, product_id, dateOfPurchase));
			}
			
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return buckets;
	}

	@Override
	public Bucket read(Integer searchId) {

		Bucket bucket = null;
		
		try {
			
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(READ);
			preparedStatement.setInt(1, searchId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				Integer user_id = resultSet.getInt("user_id");
				Integer product_id = resultSet.getInt("product_id");
				LocalDateTime dateOfPurchase = ConnectionUtils.parseToLocalDateTime(resultSet.getString("dateOfPurchase"));
				
				bucket = new Bucket(id, user_id, product_id, dateOfPurchase);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return bucket;
	}
	
	@Override
	public void save(Bucket t) {
		
		try {
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(SAVE);
			preparedStatement.setInt(1, t.getUser_id());
			preparedStatement.setInt(2, t.getProduct_id());
			preparedStatement.setString(3, ConnectionUtils.parseToMsqlString(t.getDateOfPurchase()));
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
	public void update(Bucket t) {

		try {
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(UPDATE);
			preparedStatement.setInt(1, t.getUser_id());
			preparedStatement.setInt(2, t.getProduct_id());
			preparedStatement.setString(3, ConnectionUtils.parseToMsqlString(LocalDateTime.now()));
			preparedStatement.setInt(4, t.getId());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			LOGGER.error(e);
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
			LOGGER.error(e);
		}
	}

	

	
	
}
