package DaoImpl;

import Bean.Jdonsale;
import DAO.BaseDao;
import DAO.JDOnSaleDao;

import java.util.List;

/**
 * Created by mm on 2017/6/11.
 */
public class JDOnSaleDaoImpl implements JDOnSaleDao {
    BaseDao baseDao=new BaseDaoImpl();
    @Override
    public void save(Jdonsale jDOnSale) {
        baseDao.persist(jDOnSale);
    }

    @Override
    public Jdonsale findByMovieName(String movieName) {
        String hql="from Jdonsale j where j.movieName='"+movieName+"'";
        List<Jdonsale> list=baseDao.findByHql(hql);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }
}
