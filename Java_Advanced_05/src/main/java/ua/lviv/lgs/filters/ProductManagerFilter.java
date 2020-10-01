package ua.lviv.lgs.filters;


import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import ua.lviv.lgs.shared.FilterService;

/**
 * Servlet Filter implementation class ProductManagerFilter
 */
@WebFilter("/productManager")
public class ProductManagerFilter implements Filter {
	
	FilterService filterService = null;

    /**
     * Default constructor. 
     */
    public ProductManagerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		filterService.doFilterValidation(request, response, chain, Arrays.asList(new String[] {"user"}));
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		filterService = FilterService.getFilterService();
	}

}
