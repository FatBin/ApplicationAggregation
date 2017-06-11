package DaoImpl;

import Bean.Jdonsale;
import DAO.BaseDao;
import DAO.JDOnSaleDao;

/**
 * Created by mm on 2017/6/11.
 */
public class JDOnSaleDaoImpl implements JDOnSaleDao {
    BaseDao baseDao=new BaseDaoImpl();
    @Override
    public void save(Jdonsale jDOnSale) {
        baseDao.persist(jDOnSale);
    }
}
