package conexao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			factory = null;
		}
	}
	
	public static Session getSession() {
		
		return factory.openSession();
		
	}

}
