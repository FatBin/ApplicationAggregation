package crawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import pylcrawler.NetEaseMovieGetter;
import pylcrawler.NuoMiMovie;
import pylcrawler.NuoMiMovieComingSoon;
import pylcrawler.NuoMiMovieGetter;

/**
 * Created by mm on 2017/6/8.
 */
public class tesst {
	
	public static void main(String[] args) {
		try {
			
			
			//NM ONSHOW
			
//			NuoMiMovieGetter getter=new NuoMiMovieGetter();
			
//			ArrayList<NuoMiMovie> movies=getter.getNuoMiMoviesisON();
//			
//			System.out.println("################RESULT###############");
//			
//			System.out.println(movies.get(5));
//			
//			System.out.println(movies.get(5).getTicketlist().get(12));
			
			
			
			//NM COMINGSOON
			
//			ArrayList<NuoMiMovieComingSoon> comingsoons=getter.getNuoMiMoviesComingSoon();
//			
//			
//			for (NuoMiMovieComingSoon nuoMiMovieComingSoon : comingsoons) {
//				System.out.println(nuoMiMovieComingSoon);
//				System.out.println("--------------------------");
//			}
			
			
			
			// NE ONSHOW
			
			NetEaseMovieGetter getter =new NetEaseMovieGetter();
			
			getter.getNetEaseMovieIsON();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
