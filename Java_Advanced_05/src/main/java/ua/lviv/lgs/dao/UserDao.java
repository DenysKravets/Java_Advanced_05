package ua.lviv.lgs.dao;

import ua.lviv.lgs.shared.AbstractCRUD;
import ua.lviv.lgs.domain.User;

public interface UserDao extends AbstractCRUD<User>, CloseConnection{
	
	public User readUserByEmail(String email); 
	
}
