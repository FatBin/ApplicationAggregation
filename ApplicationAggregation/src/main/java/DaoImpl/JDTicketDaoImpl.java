package DaoImpl;

import Bean.Jdticket;
import DAO.BaseDao;
import DAO.JDTicketDao;

import java.util.List;

/**
 * Created by mm on 2017/6/11.
 */
public class JDTicketDaoImpl implements JDTicketDao {
    BaseDao baseDao=new BaseDaoImpl();
    @Override
    public void save(Jdticket jDTicket) {
        baseDao.persist(jDTicket);
    }

    @Override
    public List<Jdticket> find(String movieName, String theater, String date) {
        String hql="from Jdticket j where j.movie='"+movieName+"' and j.theater='"+theater+"' and j.date='"+date+"'";
        List<Jdticket> list=baseDao.findByHql(hql);
        return list;
    }
}
