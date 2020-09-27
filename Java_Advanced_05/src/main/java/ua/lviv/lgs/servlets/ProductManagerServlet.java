package ua.lviv.lgs.servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = "/productManager")
public class ProductManagerServlet extends HttpServlet {
	
	/**
	 * I have no idea why this is needed but whatever.
	 */
	private static final long serialVersionUID = 1L;

	ProductService productService = new ProductServiceImpl();

	// to create resource (product)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsonString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		JSONParser jsonParser = new JSONParser();
		JSONObject object = null;
				
		try {
			object = (JSONObject) jsonParser.parse(jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		String name = (String) object.getOrDefault("name", "");
		String description = (String) object.getOrDefault("description", "");
		String price = (String) object.getOrDefault("price", "");
		
		if (!name.isEmpty() && !description.isEmpty() && !price.isEmpty()) {
			
			productService.save(new Product(name, description, getValidatedPrice(price)));
			
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
		
	}
	
	private double getValidatedPrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

	// to get resource (product)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// to update resource (product)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	// to delete resource (product)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

}