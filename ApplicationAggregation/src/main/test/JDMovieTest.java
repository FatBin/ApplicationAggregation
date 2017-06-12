import Bean.Jdonsale;
import Bean.Jdticket;
import DAO.JDOnSaleDao;
import DAO.JDTicketDao;
import DaoImpl.JDOnSaleDaoImpl;
import DaoImpl.JDTicketDaoImpl;
import Wrapper.JDXML;
import XMLBean.ArrayAll;
import XMLBean.JD;
import XMLParse.XMLParse;
import lxbincrawler.JDMovieCrawler;
import lxbincrawler.JDTicket;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mm on 2017/6/10.
 */
public class JDMovieTest {
    JDMovieCrawler jdMovieCrawler=new JDMovieCrawler();

    @Test
    public void GetOnSaleFromHomepage(){
//        JDOnSaleDao jdOnSaleDao=new JDOnSaleDaoImpl();
//        Jdonsale jdonsale=new Jdonsale();
//        jdonsale.setMovieId("110");
//        jdonsale.setDirector("123");
//        jdOnSaleDao.save(jdonsale);


//        JDTicketDao jdTicketDao=new JDTicketDaoImpl();
//        JDMovieCrawler crawler=new JDMovieCrawler();
//        ArrayList<JDTicket> arrayList= crawler.process();
//        for (JDTicket j :
//                arrayList) {
//            System.out.println(j.getMovieId()+" "+j.getMovie()+" "+j.getTheaterId()+" "+j.getTheater()+" "+j.getDate()+" "+j.getBegin()+" "+j.getEnd()
//                    +" "+j.getHall()+" "+j.getPrice()+" "+j.getSponsor()+" "+j.getLanguage());
//            Jdticket jdticket=new Jdticket();
//            jdticket.setMovieId(j.getMovieId());
//            jdticket.setMovie(j.getMovie());
//            jdticket.setTheaterId(j.getTheaterId());
//            jdticket.setTheater(j.getTheater());
//            jdticket.setDate(j.getDate());
//            jdticket.setBegin(j.getBegin());
//            jdticket.setEnd(j.getEnd());
//            jdticket.setHall(j.getHall());
//            jdticket.setPrice(j.getPrice());
//            jdticket.setSponsor(j.getSponsor());
//            jdticket.setLanguage(j.getLanguage());
//            jdTicketDao.save(jdticket);
//                }
//        JDTicketDaoImpl jdTicketDao=new JDTicketDaoImpl();
//        ArrayList<Jdticket> jdtickets= (ArrayList<Jdticket>) jdTicketDao.find("中国推销员","幸福蓝海国际影城江宁店","2017-06-16");
//        for (Jdticket j:jdtickets
//             ) {
//            System.out.println(j.getMovieId()+" "+j.getHall()+" "+j.getBegin());
//        }

//        JDOnSaleDaoImpl j=new JDOnSaleDaoImpl();
//        Jdonsale jdonsale=j.findByMovieName("中国推销员");
//        System.out.println(jdonsale.getActors());


        JDXML jdxml=new JDXML();
        System.out.println(XMLParse.convertToXml(XMLParse.converyToJavaBean(jdxml.getData("神农溪之恋漂洋过海来爱你","南京沃美影城","2017-06-13"), ArrayAll.class),"utf-8"));

    }

    @Test
    public void save() {
//        JD jd=new JD();
//        jd.setActors("");
//        jd.setAddress("");
//        jd.setBegin("");
//        jd.setDate("");
//        jd.setDirector("");
//        jd.setEnd("");
//        jd.setHall("");
//        jd.setIntroduction("");
//        jd.setLanguage("");
//        jd.setTheater("");
//        jd.setTag("");
//        jd.setSponser("-");
//        jd.setPrice(1.0);
//        jd.setScore(2.0);
//        String s=XMLParse.convertToXml(jd,"utf-8");
//        System.out.println(s);
    }
}
