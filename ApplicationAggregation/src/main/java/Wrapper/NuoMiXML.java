package Wrapper;

import java.util.ArrayList;
import java.util.List;

import Bean.Nuomimovie;
import Bean.Ticket;
import DAO.NuoMiMovieDao;
import DAO.TicketDao;
import DaoImpl.NuoMiMovieDaoImpl;
import DaoImpl.TicketDaoImpl;
import WrapperService.NuoMiService;
import XMLBean.Actor;
import XMLBean.All;
import XMLBean.ArrayAll;
import XMLParse.XMLParse;

/**
 * Created by mm on 2017/6/11.
 */
public class NuoMiXML implements NuoMiService {
    @Override
    public String getData(String movieName, String theater, String date) {
        NuoMiMovieDao movieDao=new NuoMiMovieDaoImpl();
        TicketDao ticketDao=new TicketDaoImpl();
        
        List<Ticket> tickets=ticketDao.find(movieName, theater, date);
        Nuomimovie nuomimovie=movieDao.findByMovieName(movieName);
        
        ArrayList<All> arrayList=new ArrayList<>();
        
        for (Ticket ticket : tickets) {
			All interTicket=new All();
			
			 if (nuomimovie.getStars().length()>2&&nuomimovie.getStars()!=null){
	                String temp=nuomimovie.getStars();
	                String[] actors=temp.substring(1,temp.length()-1).split(",");
	                for (String actor:actors){
	                	interTicket.getActor().getNames().add(actor);
	                }
	            }else {
	            	interTicket.getActor().getNames().add("-");
	            }
		interTicket.setAddress(ticket.getAddress());
		
		
		//////////////
		String ticketdate="";
		String beginTime="";
		
		String[] reStrings=ticket.getTicketStartDate().split(",");
		if(reStrings.length==2){
			ticketdate=reStrings[0];
			beginTime=reStrings[1];
		}else if (reStrings.length==1) {
			ticketdate=reStrings[0];
			beginTime="-";
		}else {
			ticketdate="-";
			beginTime="-";
		}
		
		
		//////////////
		
		
		interTicket.setBegin(beginTime);
		
		interTicket.setDate(ticketdate);
		
		
		interTicket.setCountry(nuomimovie.getCountry());
		
		
		interTicket.setDirector(nuomimovie.getDirector());
		
		interTicket.setDuration(nuomimovie.getDuration());
		
		interTicket.setEnd("-");
		
		interTicket.setHall("-");
		
		interTicket.setIntroduction(nuomimovie.getIntro());
		
		interTicket.setLanguage("-");
		
		interTicket.setMoviename(nuomimovie.getName());
		
		interTicket.setPrice(ticket.getPrice());
		
		
		try {
			double rank=Double.parseDouble(nuomimovie.getRank());
			interTicket.setScore(rank);
		} catch (Exception e) {
			// TODO: handle exception
			interTicket.setScore(0);
		}
		
		interTicket.setSponser("-");
		
		interTicket.setStartDate(nuomimovie.getStartDate());
		
		interTicket.setTag("-");
		
		interTicket.setTheater(ticket.getTheaterName());
		
		arrayList.add(interTicket);
		
		}
        ArrayAll arrayJD=new ArrayAll();
        arrayJD.setAlls(arrayList);
        String result=XMLParse.convertToXml(arrayJD,"utf-8");
        return result;
    	
    }
}
