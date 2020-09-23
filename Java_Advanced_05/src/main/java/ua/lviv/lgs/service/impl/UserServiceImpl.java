package ua.lviv.lgs.service.impl;

import java.util.List;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.dao.impl.UserDaoImpl;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = null;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public void save(User t) {
		userDao.save(t);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public void update(User t) {
		userDao.update(t);
	}

	@Override
	public User readUserByEmail(String email) {
		return userDao.readUserByEmail(email);
	}
	

}
