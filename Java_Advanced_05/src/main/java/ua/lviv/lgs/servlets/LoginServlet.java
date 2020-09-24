package ua.lviv.lgs.servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
		
		String jsonString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		JSONParser jsonParser = new JSONParser();
		JSONObject object = null;
				
		try {
			object = (JSONObject) jsonParser.parse(jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String email = (String) object.getOrDefault("email", "");
		String password = (String) object.getOrDefault("password", "");
		
		UserService userService = new UserServiceImpl();
		User user = userService.readUserByEmail(email);
		
		if(user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			object.clear();
			object.put("url", "http://localhost:8080/Java_Advanced_05/mainPage.jsp");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(object.toString());
		} 
		
	}

}