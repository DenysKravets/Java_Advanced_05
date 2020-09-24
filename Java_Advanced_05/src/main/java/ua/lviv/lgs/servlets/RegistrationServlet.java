package ua.lviv.lgs.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
		
		String jsonString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		JSONParser jsonParser = new JSONParser();
		JSONObject object = null;
				
		try {
			object = (JSONObject) jsonParser.parse(jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		String firstName = (String) object.getOrDefault("firstName", "");
		String lastName = (String) object.getOrDefault("lastName", "");
		String email = (String) object.getOrDefault("email", "");
		String role = "user";
		String password = (String) object.getOrDefault("password", "");
		
		UserService userService = new UserServiceImpl();
		

		
		if (!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
			userService.save(new User(firstName, lastName, email, role, password));
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
		
	}

}