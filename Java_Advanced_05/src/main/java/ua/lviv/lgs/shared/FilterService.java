package ua.lviv.lgs.shared;

import java.io.IOException;
import java.util.List;
import ua.lviv.lgs.domain.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterService {
	
	static FilterService filterService = null;
	
	private FilterService() {
		
	}
	
	public static FilterService getFilterService() {
		if(filterService == null) {
			filterService = new FilterService();
		}
		
		return filterService;
	}
	
	public void doFilterValidation(ServletRequest request, ServletResponse response, FilterChain chain, List<String> roles)
			throws IOException, ServletException {
		
		try {
			
			String role = ((User) ((HttpServletRequest) request).getSession().getAttribute("user")).getRole();
			
			if(role != null && roles.contains(role)) {
				chain.doFilter(request, response);
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}
	
}