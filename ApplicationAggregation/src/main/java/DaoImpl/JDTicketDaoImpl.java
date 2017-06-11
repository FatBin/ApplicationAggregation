package DaoImpl;

import Bean.Jdticket;
import DAO.BaseDao;
import DAO.JDTicketDao;

/**
 * Created by mm on 2017/6/11.
 */
public class JDTicketDaoImpl implements JDTicketDao {
    BaseDao baseDao=new BaseDaoImpl();
    @Override
    public void save(Jdticket jDTicket) {
        baseDao.persist(jDTicket);
    }
}
