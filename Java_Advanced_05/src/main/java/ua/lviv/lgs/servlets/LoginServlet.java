package ua.lviv.lgs.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;





@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * I have no idea why this is needed but whatever.
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserService userService = new UserServiceImpl();
		User user = userService.readUserByEmail(email);
		
		if(user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("/Java_Advanced_05/mainPage.jsp");
		} else {
			response.sendRedirect("/Java_Advanced_05/login");
		}
		
		
	}

}