package DaoImpl;

import DAO.BaseDao;
import DAO.TrainingSetDao;

import java.util.List;

/**
 * Created by mm on 2017/7/10.
 */
public class TrainingSetDaoImpl implements TrainingSetDao{
    BaseDao baseDao=new BaseDaoImpl();
    @Override
    public List getAll() {
        return baseDao.findAll("Trainingset");
    }
}
