package DaoImpl;

import DAO.JDOnSaleDao;
import DAO.JDTicketDao;
import DAO.NuoMiMovieDao;
import DAO.TicketDao;

public class DaoFactory {
	public static JDOnSaleDao getCardDao(){
		return  JDOnSaleDaoImpl.getInstance();
	}
	
	
	public static JDTicketDao getHostelDao(){
		return JDTicketDaoImpl.getInstance();
	}
	
	public static NuoMiMovieDao getReserveDao(){
		return NuoMiMovieDaoImpl.getInstance();
	}
	
	public static TicketDao getRoomDao(){
		return TicketDaoImpl.getInstance();
	}

}
