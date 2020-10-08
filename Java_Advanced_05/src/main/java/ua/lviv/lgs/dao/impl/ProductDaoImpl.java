package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.shared.FactoryManager;
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
	
	private EntityManagerFactory emf = FactoryManager.getEntityManagerFactory();
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public List<Product> readAll() {
		
		Query query = null;
		
		try {
			
			query = em.createQuery("SELECT e FROM Product e");
			
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return query.getResultList();
	}

	@Override
	public Product read(Integer searchId) {

		Product product = null;
		
		try {
			
			product = em.find(Product.class, searchId);
			
				
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return product;
	}
	
	@Override
	public void save(Product product) {
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(product);
			
			em.getTransaction().commit();
						
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
	}

	@Override
	public void delete(Integer id) {
		
		try {
			
			
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
	}

	@Override
	public void update(Product product) {

		try {
			
			
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
