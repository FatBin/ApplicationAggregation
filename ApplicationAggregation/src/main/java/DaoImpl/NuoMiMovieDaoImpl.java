package DaoImpl;

import Bean.Nuomimovie;
import DAO.BaseDao;
import DAO.NuoMiMovieDao;

/**
 * Created by mm on 2017/6/11.
 */
public class NuoMiMovieDaoImpl implements NuoMiMovieDao {
    BaseDao baseDao=new BaseDaoImpl();
    @Override
    public void save(Nuomimovie nuoMiMovie) {
        baseDao.persist(nuoMiMovie);
    }
}
