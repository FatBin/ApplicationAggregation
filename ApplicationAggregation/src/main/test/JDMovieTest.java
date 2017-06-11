import Bean.Jdonsale;
import DAO.JDOnSaleDao;
import DaoImpl.JDOnSaleDaoImpl;
import lxbincrawler.JDMovieCrawler;
import org.junit.Test;

/**
 * Created by mm on 2017/6/10.
 */
public class JDMovieTest {
    JDMovieCrawler jdMovieCrawler=new JDMovieCrawler();

    @Test
    public void GetOnSaleFromHomepage(){
        JDOnSaleDao jdOnSaleDao=new JDOnSaleDaoImpl();
        Jdonsale jdonsale=new Jdonsale();
        jdonsale.setMovieId("110");
        jdonsale.setDirector("123");
        jdOnSaleDao.save(jdonsale);
    }
}
