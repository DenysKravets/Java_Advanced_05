package ua.lviv.lgs.shared;

import java.util.List;

public interface AbstractCRUD<T> {

	List<T> readAll();
	
	T read(Integer id);
	
	void save(T t);
	
	void delete(Integer id);
	
	void update(T t);
	
}
