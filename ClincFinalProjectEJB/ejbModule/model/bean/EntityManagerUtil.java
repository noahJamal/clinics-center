package model.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static final EntityManagerFactory entityManagerFactory;
	
	static{
		try{
		entityManagerFactory=Persistence.createEntityManagerFactory("ClincFinalProjectEJB");
		}
		catch (Throwable ex) {
			// TODO: handle exception
			throw new ExceptionInInitializerError(ex);
		}
		
		
	}
	public static EntityManager getEntityMamager()
	{
		return entityManagerFactory.createEntityManager();
	}

}
