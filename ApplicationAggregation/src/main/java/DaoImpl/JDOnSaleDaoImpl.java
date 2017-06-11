package DaoImpl;


import Bean.JDOnSale;
import DAO.JDOnSaleDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class JDOnSaleDaoImpl implements JDOnSaleDao {

	private Configuration config;
	private ServiceRegistry serviceRegistry;
	private SessionFactory sessionFactory;
	private Session session;
	public static JDOnSaleDaoImpl jDOnSaleDaoImpl =
			new JDOnSaleDaoImpl();
	
	private JDOnSaleDaoImpl(){
		
	}
	
	public static JDOnSaleDaoImpl getInstance(){
		return jDOnSaleDaoImpl;
	}
	
	@Override
	public void save(JDOnSale jDOnSale) {

		config = new Configuration().configure();
		config.addAnnotatedClass(JDOnSale.class);
		serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory=config.buildSessionFactory(serviceRegistry);	
		session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();

		session.save(jDOnSale); 
		tx.commit();
		session.close();
		sessionFactory.close();
		System.out.println("save jDOnSale info,ok");
	
		

	}
	
	

}
