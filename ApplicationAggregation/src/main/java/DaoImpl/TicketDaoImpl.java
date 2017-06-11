package DaoImpl;

import Bean.Ticket;
import DAO.TicketDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class TicketDaoImpl implements TicketDao {

	private Configuration config;
	private ServiceRegistry serviceRegistry;
	private SessionFactory sessionFactory;
	private Session session;
	public static TicketDaoImpl ticketDaoImpl =
			new TicketDaoImpl();
	
	private TicketDaoImpl(){
		
	}
	
	public static TicketDaoImpl getInstance(){
		return ticketDaoImpl;
	}
	
	@Override
	public void save(Ticket ticket) {

		config = new Configuration().configure();
		config.addAnnotatedClass(Ticket.class);
		serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory=config.buildSessionFactory(serviceRegistry);	
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();

		session.save(ticket); 
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("save ticket info,ok");
	

	}

}
