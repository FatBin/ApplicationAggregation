package DaoImpl;

import java.util.List;

import Bean.Jdticket;
import Bean.Ticket;
import DAO.BaseDao;
import DAO.TicketDao;

/**
 * Created by mm on 2017/6/11.
 */
public class TicketDaoImpl implements TicketDao {
    BaseDao baseDao=new BaseDaoImpl();
    @Override
    public void save(Ticket ticket) {
        baseDao.persist(ticket);
    }
    
    
    @Override
    public List<Ticket> find(String movieName, String theater, String date) {
//        String hql="from Ticket j where j.movieName='"+movieName+"' and j.theaterName='"+theater+"' and j.ticketStartDate like '%"+date+"%'";
        
    	
      String hql="from Ticket j where j.movieName like '%"+movieName+"%' and j.theaterName like '%"+theater+"%' and j.ticketStartDate like '%10:00%'";

    	List<Ticket> list=baseDao.findByHql(hql);
        return list;
    }
}
