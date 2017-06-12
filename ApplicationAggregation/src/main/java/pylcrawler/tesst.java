package pylcrawler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import pylcrawler.NuoMiMovieGetter;
import pylcrawler.NuoMiTicket;

/**
 * Created by mm on 2017/6/8.
 */
public class tesst {
	
	public static void main(String[] args) {
		try {
			
			
			//NM ONSHOW
//////			
			NuoMiMovieGetter getter=new NuoMiMovieGetter();	
			ArrayList<NuoMiMovie> movies=getter.getNuoMiMoviesisON();

			
			System.out.println("################RESULT###############");
			
			System.out.println(movies.get(5));
			
			System.out.println(movies.get(5).getTicketlist().get(12));
			
			save(movies);
			
			
			
			
			
			
			
			
			
			
			

			
			//NM COMINGSOON
			
//			ArrayList<NuoMiMovieComingSoon> comingsoons=getter.getNuoMiMoviesComingSoon();
//			
//			
//			for (NuoMiMovieComingSoon nuoMiMovieComingSoon : comingsoons) {
//				System.out.println(nuoMiMovieComingSoon);
//				System.out.println("--------------------------");
//			}
			
			
			
			
			
			// NE ONSHOW
			
//			NetEaseMovieGetter getter =new NetEaseMovieGetter();
//			
//			getter.getNetEaseMovieIsON();
			
			
//			tesst tesst=new tesst();
//			
//			tesst.testThird();
			
			
//			ArrayList<String> stars=new ArrayList<>();
//			
//			stars.add("star1");
//			stars.add("star2");
//			stars.add("star3");
//			stars.add("star4");
//			
//			
//			NuoMiMovie movie1=new NuoMiMovie();
//			movie1.setCountry("us");
//			movie1.setDetailLink("dl");
//			movie1.setDirector("director");
//			movie1.setDuration("100");
//			movie1.setIntro("intro");
//			movie1.setName("movie1");
//			movie1.setStars(stars);
//			
//			ArrayList<NuoMiTicket> nuoMiTickets=new ArrayList<>();
//			
//			NuoMiTicket ticket=new NuoMiTicket();
//			
//			ticket.setAddress("addresss");
//			ticket.setPrice(10);
//			ticket.setTheaterName("therddd");
//			
//			ticket.setStartDate("2017-12-12");
//			
//			
//			
//			ArrayList<NuoMiMovie> movielist=new ArrayList<>();
//			
//			movielist.add(movie1);
//			
//			nuoMiTickets.add(ticket);
//			
//			movie1.setTicketlist(nuoMiTickets);
//			
//			save(movielist);
//			
//			System.out.println(convertToXml(movie1));
			
			
//			read();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	 public static String convertToXml(Object obj) {  
	        return convertToXml(obj, "UTF-8");  
	    }  
	  
	    /** 
	     * JavaBean转换成xml. 
	     *  
	     * @param obj 
	     *            bean实体 
	     * @param encoding 
	     *            默认编码UTF-8 
	     * @return 
	     */  
	    private static String convertToXml(Object obj, String encoding) {  
	        String result = null;  
	        try {  
	            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
	            Marshaller marshaller = context.createMarshaller();  
	            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
	  
	            StringWriter writer = new StringWriter();  
	            marshaller.marshal(obj, writer);  
	            result = writer.toString();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  
	        return result;  
	    }  
	
	
	private void testThird(){
		NuoMiMovieGetter getter=new NuoMiMovieGetter();
		getter.thirdLayer("za", "add", "https://mdianying.baidu.com/cinema/detail?cinemaId=9434#showing","15546");
	}
	
	
	private void test(){
		WebClient webclient=new WebClient();
		HtmlPage page;
		NuoMiMovieGetter getter=new NuoMiMovieGetter();
		
		
		try {
			
		
		page = webclient.getPage("https://dianying.nuomi.com/movie/detail?movieId=15546&cityId=315");
		webclient.waitForBackgroundJavaScript(50000);
		DomElement btn=page.getElementById("moreCinema");
		
		if(btn==null){
			System.out.println("unsupport");
		}
		
		
		while(!btn.getTextContent().contains("没有")){
			btn.click();
			webclient.waitForBackgroundJavaScript(50000);
			btn=page.getElementById("moreCinema");
			
		}
		
		DomElement list=page.getElementById("pageletCinemalist");
		
		DomNodeList<HtmlElement> listitems=list.getElementsByTagName("li");
		
		for(int i=0;i<listitems.getLength();i++ ){
			
			
			ArrayList<NuoMiTicket> ticket=getter.parseTicketli(listitems.get(i));
			
			for (NuoMiTicket nuoMiTicket : ticket) {
				System.out.println(nuoMiTicket);
			}
			
			
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	
	public static void  save(ArrayList<NuoMiMovie> movies){
		 FileOutputStream fos;
		try {
			fos = new FileOutputStream("/Users/peiyulin/Documents/movies.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(movies);
			
			oos.close();
			
			
			System.out.println("SAVED--------------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void read(){
		FileInputStream fis;
		try {
			fis = new FileInputStream("/Users/peiyulin/Documents/movies.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<NuoMiMovie> list=(ArrayList<NuoMiMovie>)ois.readObject();
			
			
			System.out.println(list.get(0));
			
			System.out.println(list.get(0).getTicketlist().get(0));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
    
	}
	
	
	
	
}
