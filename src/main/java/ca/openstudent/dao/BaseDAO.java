package ca.openstudent.dao;

/**
 * 
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProviderResolverHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseDAO implements DAO {

		private final static Logger logger = LoggerFactory.getLogger(BaseDAO.class);

		protected static EntityManagerFactory EMF;

		static {
			logger.info("Initializing EntityManagerFactory...");
			logger.info("providers:"
					+ PersistenceProviderResolverHolder
							.getPersistenceProviderResolver()
							.getPersistenceProviders());
		}

		public EntityManager getEntityManager() {
			if(EMF == null) {
				
				EMF =  Persistence.createEntityManagerFactory("openStudent");
			}

			return EMF.createEntityManager();
		}

		public boolean delete(Long id, Class <?> clazz) {
			EntityManager e = getEntityManager();
			EntityTransaction t = null;
			try {
				t = e.getTransaction();
				t.begin();
				Object b = e.find(clazz, id);
				e.remove(b);
				t.commit();
				return true;
			} catch (Exception ex) {
				if (t != null && t.isActive())
					t.rollback();
				logger.error(ex.getMessage(), ex);
				return false;
			} finally {
				e.close();
			}
		}

		public boolean save(Object object) {
			EntityManager e = getEntityManager();
			EntityTransaction t = null;
			try {
				t = e.getTransaction();
				t.begin();
				e.merge(object);
				t.commit();
				return true;
			} catch (Exception ex) {
				if (t != null && t.isActive())
					t.rollback();
				ex.printStackTrace(System.out);
				return false;
			} finally {
				e.close();
			}
		}

		public Object findById(Long id, Class <?> clazz) {
			return getEntityManager().find(clazz, id);
		}

		public List<?> findAll(String query) {
			return getEntityManager().createQuery(query).getResultList();
		}

	}