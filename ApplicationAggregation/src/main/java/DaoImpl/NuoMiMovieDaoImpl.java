package DaoImpl;

import Bean.NuoMiMovie;
import DAO.NuoMiMovieDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class NuoMiMovieDaoImpl implements NuoMiMovieDao {

	private Configuration config;
	private ServiceRegistry serviceRegistry;
	private SessionFactory sessionFactory;
	private Session session;
	public static NuoMiMovieDaoImpl nuoMiMovieDaoImpl =
			new NuoMiMovieDaoImpl();
	
	private NuoMiMovieDaoImpl(){
		
	}
	
	public static NuoMiMovieDaoImpl getInstance(){
		return nuoMiMovieDaoImpl;
	}
	
	@Override
	public void save(NuoMiMovie NuoMiMovie) {

		config = new Configuration().configure();
		config.addAnnotatedClass(NuoMiMovie.class);
		serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory=config.buildSessionFactory(serviceRegistry);	
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();

		session.save(NuoMiMovie); 
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("save nuoMiMovie info,ok");
	

	}

}
