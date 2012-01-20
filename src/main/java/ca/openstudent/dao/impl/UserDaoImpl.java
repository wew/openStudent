package ca.openstudent.dao.impl;

import javax.persistence.EntityManager;

import ca.openstudent.auth.User;
import ca.openstudent.dao.DAOException;

public class UserDaoImpl {

	private EntityManager em;
	
	public UserDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public void create(User user) {
		em.joinTransaction();
		em.persist(user);
	}

	public void update(User user) {
		em.joinTransaction();
		em.merge(user);
	}
	
	public void remove(Long id) throws DAOException {
		em.joinTransaction();
		User entity = em.find(User.class, id);
		if (entity != null) 
		{
			em.remove(entity);
		}
		else
		{
			throw new DAOException("No such User ID: " + id);
		}
	}
	
	public User find(long id) {
		return em.find(User.class, id);
	}
}
