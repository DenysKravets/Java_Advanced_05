package ua.lviv.lgs.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dto.BucketDto;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = "/bucket")
public class BucketServlet extends HttpServlet {
	
	/**
	 * I have no idea why this is needed but whatever.
	 */
	private static final long serialVersionUID = 1L;

	BucketService bucketService = new BucketServiceImpl();
	ProductService productService = new ProductServiceImpl();

	// to create resource (bucket)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Bucket> buckets = bucketService.readAll();
		List<BucketDto> bucketDtos = null;
		
		User user = (User) request.getSession().getAttribute("user");
		
		bucketDtos = buckets.stream().filter(bucket -> {
			if(bucket.getUser_id().equals(user.getId())) {
				return true;
			} else {
				return false;
			}
		}).map(bucket -> {
			Product product = productService.read(bucket.getProduct_id());
			return new BucketDto(bucket.getId(), product.getName(), product.getDescription(), product.getPrice(), bucket.getDateOfPurchase());
		}).collect(Collectors.toList());
		
		String json = new Gson().toJson(bucketDtos);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		bucketService.delete(Integer.parseInt(req.getParameter("id")));
		
	}

}