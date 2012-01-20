package ca.openstudent.dao;

import java.util.List;

public interface DAO {

	public boolean save(Object dao);

	public boolean delete(Long id, Class <?> clazz);

	public Object findById(Long id, Class <?> clazz);
	
	public List<?> findAll(String query);
}

