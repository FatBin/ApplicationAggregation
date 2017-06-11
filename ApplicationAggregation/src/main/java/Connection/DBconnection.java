package Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by mm on 2016/10/6.
 */
public class DBconnection {
    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    private DBconnection(){

    }


    public static Session getSession(){
        if (sessionFactory==null){
            configuration=new Configuration().configure();
            sessionFactory=configuration.buildSessionFactory();
            return sessionFactory.openSession();
        }else {
            return sessionFactory.openSession();
        }
    }

    public static void closeSession(Session session){
        session.close();
    }
}
