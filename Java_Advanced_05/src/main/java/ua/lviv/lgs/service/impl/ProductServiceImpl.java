package ua.lviv.lgs.service.impl;

import java.util.List;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService{

	ProductDao productDao = null;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}
	
	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public void save(Product t) {
		productDao.save(t);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public void update(Product t) {
		productDao.update(t);
	}

}
