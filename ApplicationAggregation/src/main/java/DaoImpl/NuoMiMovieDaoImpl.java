package DaoImpl;

import java.util.List;

import Bean.Jdonsale;
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
    
    
    
    @Override
    public Nuomimovie findByMovieName(String movieName) {
        String hql="from Nuomimovie j where j.name='"+movieName+"'";
        List<Nuomimovie> list=baseDao.findByHql(hql);
        if (list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }
}


