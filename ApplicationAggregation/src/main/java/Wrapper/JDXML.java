package Wrapper;

import Bean.Jdonsale;
import Bean.Jdticket;
import DAO.JDOnSaleDao;
import DAO.JDTicketDao;
import DaoImpl.JDOnSaleDaoImpl;
import DaoImpl.JDTicketDaoImpl;
import WrapperService.JDService;
import XMLBean.All;
import XMLBean.ArrayAll;
import XMLBean.JD;
import XMLParse.XMLParse;

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

        ArrayList<All> arrayList=new ArrayList<>();
        for (Jdticket j:jdtickets
             ) {
            All jd=new All();
            jd.setMoviename(j.getMovie());
            jd.setScore(jdonsale.getScore());

            if (jdonsale.getActors().length()>2&&jdonsale.getActors()!=null){
                String temp=jdonsale.getActors();
                String[] actors=temp.substring(1,temp.length()-1).split(",");
                for (String actor:actors){
                    jd.getActor().getNames().add(actor);
                }
            }else {
                jd.getActor().getNames().add("-");
            }

            jd.setDirector(jdonsale.getDirector());
            jd.setTag(jdonsale.getTag());
            jd.setIntroduction(jdonsale.getIntroduction());
            jd.setDetailLink("-");
            jd.setCountry("-");
            jd.setDuration("-");
            jd.setStartDate("-");
            jd.setDate(j.getDate());
            jd.setBegin(j.getBegin());
            jd.setEnd(j.getEnd());
            jd.setTheater(j.getTheater());
            jd.setHall(j.getHall());
            jd.setPrice(Double.valueOf(j.getPrice()));
            jd.setSponser(j.getSponsor());
            jd.setLanguage(j.getLanguage());
            jd.setAddress(j.getLanguage());
            arrayList.add(jd);
        }

        ArrayAll arrayJD=new ArrayAll();
        arrayJD.setAlls(arrayList);
        String result=XMLParse.convertToXml(arrayJD,"utf-8");
        return result;
    }
}
