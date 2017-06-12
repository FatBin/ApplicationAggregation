package pylcrawler;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


import Bean.Nuomimovie;
import Bean.Ticket;
import DAO.NuoMiMovieDao;
import DAO.TicketDao;
import DaoImpl.NuoMiMovieDaoImpl;
import DaoImpl.TicketDaoImpl;
import pylcrawler.NuoMiMovie;
import pylcrawler.NuoMiTicket;

	
public class WriteToDBNuoMi {
	
	
	public static void main(String[] args) {
		ArrayList<NuoMiMovie> list=read();
		
		System.out.println(list.size());
		
		 NuoMiMovieDao movieDao=new NuoMiMovieDaoImpl();
		 
		 TicketDao ticketDao=new TicketDaoImpl();
		 for (NuoMiMovie nuoMiMovie : list) {
			 
			 
			movieDao.save(getMovieBean(nuoMiMovie));
			 System.out.println(nuoMiMovie.getName());
			
			ArrayList<NuoMiTicket> tickets = nuoMiMovie.getTicketlist();
			for (NuoMiTicket nuoMiTicket : tickets) {
				Ticket ticket=geTicket(nuoMiTicket);
				
				ticket.setMovieName(nuoMiMovie.getName());
				
				System.out.println(ticket.getTicketStartDate());
				
				ticketDao.save(ticket);
			}
		}

	}
	
	
	
	public static Ticket geTicket(NuoMiTicket ticket){
		Ticket bean=new Ticket();
		
		bean.setAddress(ticket.getAddress());
		
		
		bean.setPrice(ticket.getPrice());
		
		bean.setTheaterName(ticket.getTheaterName());
		
		bean.setTicketStartDate(ticket.getStartDate());
		return bean;
	}
	
	
	public static Nuomimovie getMovieBean(NuoMiMovie movie){
		Nuomimovie bean=new Nuomimovie();
		
		bean.setCountry(movie.getCountry());
		bean.setDetailLink(movie.getDetailLink());
		
		bean.setDirector(movie.getDirector());
		
		bean.setDuration(movie.getDuration());
		
		bean.setIntro(movie.getIntro());
		
		bean.setName(movie.getName());
		
		bean.setRank(movie.getRank());
		
		
		bean.setStars(movie.getStars().toString());
		
		bean.setStartDate(movie.getStartDate());
		
		
		return bean;
		
	}
	
	
	

	
	
	
	
	
	public static ArrayList<NuoMiMovie> read(){
		FileInputStream fis;
		try {
			fis = new FileInputStream("/Users/peiyulin/Documents/movies.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<NuoMiMovie> list=(ArrayList<NuoMiMovie>)ois.readObject();
			
			
			return list;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
      
    
	}
}
