package ua.lviv.lgs.test;


import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;
import ua.lviv.lgs.shared.FactoryManager;

public class Main {
	
	
	private static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		
//		DOMConfigurator.configure("loggerConfig.xml");
		
//		UserService userService = new UserServiceImpl();
		
//		userService.save(new User("Foster", "Doloi", "foster@gmail.com", "admin", "123321"));
//		System.out.println(userService.readUserByEmail("denys@gmail.com"));
		
//		System.out.println(System.getProperty("user.dir"));
//		
//		logger.error("error in main");
		
		FactoryManager.getEntityManagerFactory();
		EntityManager em = FactoryManager.getEntityManager();
		
		UserService us = new UserServiceImpl();
		
		System.out.println(us.readUserByEmail("denys@gmail.com"));
		
	}

}
