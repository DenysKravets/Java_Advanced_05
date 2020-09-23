package ua.lviv.lgs.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;



@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

	/**
	 * I have no idea why this is needed but whatever.
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/registration.jsp").forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String role = "user";
		String password = request.getParameter("password");
		
		UserService userService = new UserServiceImpl();
		
		userService.save(new User(firstName, lastName, email, role, password));
		
		response.sendRedirect("/Java_Advanced_05/login");
		
	}

}