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

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.utils.ConnectionUtils;

public class ProductDaoImpl implements ProductDao {
	
//	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	private static Logger LOGGER = LogManager.getLogger();

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private String READ_ALL = "select * from product";
	private String READ = "select * from product where id = ?";
	private String SAVE = "insert into product(name, description, price)"
			+ " values (?, ?, ?)";
	private String DELETE = "delete from product where id = ?";
	private String UPDATE = "update product set"
			+ " name = ?, description = ?, price = ? where id = ?";
	
	public ProductDaoImpl() {
		super();
	}

	@Override
	public List<Product> readAll() {
		
		List<Product> products = new ArrayList<>();
		
		try {
			
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(READ_ALL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Double price = resultSet.getDouble("price");
				
				products.add(new Product(id, name, description, price));
			}
			
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return products;
	}

	@Override
	public Product read(Integer searchId) {

		Product product = null;
		
		try {
			
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(READ);
			preparedStatement.setInt(1, searchId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Double price = resultSet.getDouble("price");
				
				product = new Product(id, name, description, price);
			}
			
		} catch (SQLException e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return product;
	}
	
	@Override
	public void save(Product product) {
		
		try {
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(SAVE);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
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
	public void update(Product product) {

		try {
			connection = ConnectionUtils.makeConnection();
			preparedStatement = connection.prepareStatement(UPDATE);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getId());
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
