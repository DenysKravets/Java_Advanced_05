package ua.lviv.lgs.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = "/bucketManager")
public class BucketManagerServlet extends HttpServlet {
	
	/**
	 * I have no idea why this is needed but whatever.
	 */
	private static final long serialVersionUID = 1L;

	BucketService bucketService = new BucketServiceImpl();
	ProductService productService = new ProductServiceImpl();

	// to create resource (bucket)
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
				
		Integer productId = Integer.parseInt((String) object.getOrDefault("productId", "0"));
		
		Product product = productService.read(productId);
		User user = (User) request.getSession().getAttribute("user");
		
		
		if (product != null && user != null) {
			bucketService.save(new Bucket(user, product, LocalDateTime.now()));
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
		
	}

	// to get resource (bucket)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Integer id = Integer.parseInt(request.getParameter("id"));
//		
//		Product product = productService.read(id);
//		
//		request.setAttribute("id", id);
//		request.setAttribute("name", product.getName());
//		request.setAttribute("description", product.getDescription());
//		request.setAttribute("price", product.getPrice());
//		
//		request.getRequestDispatcher("/singleProduct.jsp").forward(request, response);
		
	}

	// to update resource (bucket)
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