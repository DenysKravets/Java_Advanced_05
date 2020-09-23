package ua.lviv.lgs.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

public class Main {
	
	
	private static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		
//		DOMConfigurator.configure("loggerConfig.xml");
		
//		UserService userService = new UserServiceImpl();
		
//		userService.save(new User("Foster", "Doloi", "foster@gmail.com", "admin", "123321"));
//		System.out.println(userService.readUserByEmail("denys@gmail.com"));
		
		System.out.println(System.getProperty("user.dir"));
		
		logger.error("error in main");
		
	}

}
