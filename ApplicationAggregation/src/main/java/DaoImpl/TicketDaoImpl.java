package DaoImpl;

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
}
