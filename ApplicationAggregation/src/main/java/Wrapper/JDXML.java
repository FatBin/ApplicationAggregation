package Wrapper;

import Bean.Jdonsale;
import Bean.Jdticket;
import DAO.JDOnSaleDao;
import DAO.JDTicketDao;
import DaoImpl.JDOnSaleDaoImpl;
import DaoImpl.JDTicketDaoImpl;
import WrapperService.JDService;
import XMLBean.ArrayJD;
import XMLBean.JD;
import XMLParse.XMLParse;
import org.apache.xpath.operations.Or;

import java.util.ArrayList;

/**
 * Created by mm on 2017/6/11.
 */
public class JDXML implements JDService {
    JDOnSaleDao jdOnSaleDao=new JDOnSaleDaoImpl();
    JDTicketDao jdTicketDao=new JDTicketDaoImpl();
    @Override
    public String getData(String movieName, String theater, String date ) {
        ArrayList<Jdticket> jdtickets= (ArrayList<Jdticket>) jdTicketDao.find(movieName,theater,date);
        Jdonsale jdonsale=jdOnSaleDao.findByMovieName(movieName);

        ArrayList<JD> arrayList=new ArrayList<>();
        for (Jdticket j:jdtickets
             ) {
            JD jd=new JD();
            jd.setMovieId(j.getMovieId());
            jd.setMovieName(j.getMovie());
            jd.setScore(jdonsale.getScore());
            jd.setDirector(jdonsale.getDirector());
            jd.setActors(jdonsale.getActors());
            jd.setTag(jdonsale.getTag());
            jd.setIntroduction(jdonsale.getIntroduction());
            jd.setTheater(j.getTheater());
            jd.setDate(j.getDate());
            jd.setBegin(j.getBegin());
            jd.setEnd(j.getEnd());
            jd.setHall(j.getHall());
            jd.setPrice(Double.valueOf(j.getPrice()));
            jd.setSponser(j.getSponsor());
            jd.setLanguage(j.getLanguage());
            jd.setAddress(j.getLanguage());
            arrayList.add(jd);
        }

        ArrayJD arrayJD=new ArrayJD();
        arrayJD.setJds(arrayList);
        String Orignal=XMLParse.convertToXml(arrayJD,"utf-8");
        String result=JDformat(Orignal);
        return result;
    }

    private String JDformat(String orignal) {

    }
}
