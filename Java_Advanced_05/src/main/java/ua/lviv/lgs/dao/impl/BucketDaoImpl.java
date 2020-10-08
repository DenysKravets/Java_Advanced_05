package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.shared.FactoryManager;
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
	
	private EntityManagerFactory emf = FactoryManager.getEntityManagerFactory();
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public List<Bucket> readAll() {
		
		Query query = null;
		
		try {
			
			query = em.createQuery("select e from Bucket e");
			
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return query.getResultList();
	}

	@Override
	public Bucket read(Integer searchId) {

		Bucket bucket = null;
		
		try {
			
			bucket = em.find(Bucket.class, searchId);
			
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return bucket;
	}
	
	@Override
	public void save(Bucket t) {
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(t);
			
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
			
			em.getTransaction().begin();
			
			em.remove(read(id));
			
			em.getTransaction().commit();
			
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			
		}
		
	}

	@Override
	public void update(Bucket t) {

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
