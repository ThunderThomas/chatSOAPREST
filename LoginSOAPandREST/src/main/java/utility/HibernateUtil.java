package utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import exceptions.ApplicationException;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() throws ApplicationException{
		if (sessionFactory == null) sessionFactory = buildSessionFactory();
		return sessionFactory;
	}
	
	private static SessionFactory buildSessionFactory() throws ApplicationException {
		try {
			Configuration config = new Configuration();
			config.configure("login.cfg.xml");
			ServiceRegistry serviceReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			return config.buildSessionFactory(serviceReg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}
}
