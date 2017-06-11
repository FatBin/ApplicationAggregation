package DaoImpl;

import Bean.JDTicket;
import DAO.JDTicketDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class JDTicketDaoImpl implements JDTicketDao {

	private Configuration config;
	private ServiceRegistry serviceRegistry;
	private SessionFactory sessionFactory;
	private Session session;
	public static JDTicketDaoImpl jDTicketDaoImpl =
			new JDTicketDaoImpl();
	
	private JDTicketDaoImpl(){
		
	}
	
	public static JDTicketDaoImpl getInstance(){
		return jDTicketDaoImpl;
	}
	
	@Override
	public void save(JDTicket jDTicket) {

		config = new Configuration().configure();
		config.addAnnotatedClass(JDTicket.class);
		serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory=config.buildSessionFactory(serviceRegistry);	
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();

		session.save(jDTicket); 
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("save jDTicket info,ok");
	

	}

}
