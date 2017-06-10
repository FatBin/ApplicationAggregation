package pylcrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class NuoMiMovieGetter {
	
	
	private  ArrayList<NuoMiMovie> isOnMovieList=new ArrayList<NuoMiMovie>();
	private  String movieDetailPrefix="https://dianying.nuomi.com/movie/detail?movieId=";
	
	public ArrayList<NuoMiMovieComingSoon> getNuoMiMoviesComingSoon(){
		try {
			Document doc = Jsoup.connect("https://dianying.nuomi.com").get();
			Elements lists=doc.getElementsByClass("widget-home-index-list");
			
			Element comingSoonList=lists.get(1);
			
			ArrayList<NuoMiMovieComingSoon> movies=getMovieLinkFromNuoMiComingSoon(comingSoonList);
			
			movies=getMovieDetailComingSoon(movies);
			
			return movies;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return null;
		
		
		
	}
	
	
	

	public  ArrayList<NuoMiMovie> getNuoMiMoviesisON() {
			
		try {
			Document doc = Jsoup.connect("https://dianying.nuomi.com").get();
			
			Elements lists=doc.getElementsByClass("widget-home-index-list");
			
			Element isOnList=lists.get(0);
//			
			ArrayList<NuoMiMovie> movies=getMovieLinkFromNuoMi(isOnList);
			
			movies=getMovieDetail(movies);
			
			movies=getTheaterAndPriceInfo(movies);
			
	
			return movies;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	
	
	private  ArrayList<NuoMiMovie> getMovieLinkFromNuoMi(Element httpelement) {
		Elements lilist=httpelement.getElementsByClass("item");		
		String idregx="\\{(.*?)\\}";
		ArrayList<NuoMiMovie> movies=new ArrayList<NuoMiMovie>();
		
		
		for(Element li : lilist){
			NuoMiMovie movie=new NuoMiMovie();
			Pattern pattern = Pattern.compile(idregx);
			
			Matcher matcher = pattern.matcher(li.toString());
			
			
			matcher.find();
			
			String aString=matcher.group(0);
			
			aString=aString.replaceAll("\\{&quot;movieId&quot;:", "");
			
			aString=aString.replaceAll("\\}", "");
			
			movie.setDetailLink(movieDetailPrefix+aString+"&&cityId=315");
			
			movies.add(movie);
		}
		
		return movies;	
	}

	
	
	
	
	private  ArrayList<NuoMiMovie> getMovieDetail(ArrayList<NuoMiMovie> movies){
		
		try {
		for (NuoMiMovie movie : movies) {
				Document doc = Jsoup.connect(movie.getDetailLink()).get();
				Elements h4tags=doc.getElementsByTag("h4");
				
				String preTitle=h4tags.get(0).toString();
				
				String name=preTitle.replaceAll("<h4 class=\"subtitle\">", "");
				
				name=name.replaceAll("</h4>", "");
				movie.setName(name);
				////get MOVIE NAME
				
				
				
				
				
				////get Rank
				
				Elements rankELEs=doc.getElementsByClass("nuomi-orange font16 fl num");
				String rankELE=rankELEs.get(0).toString();
				rankELE=rankELE.replaceAll("<span class=\"nuomi-orange font16 fl num\">", "");
				rankELE=rankELE.replaceAll("</span>", "");
				
				movie.setRank(rankELE);
				
				String directorRegx="<span>导演：</span>(.*?)</p>";
				String starRegx="<span>主演：</span>(.*?)</p>";
				String introRegx="<span>剧情：</span>(.*?)</p>";
				String countryRegx="<span>地区：</span>(.*?)</p>";
				String durationRegx="<span>片长：</span>(.*?)</p>";
				String startDateRegx="<span>上映时间：</span>(.*?)</p>";
				
				
				Elements hideELES=doc.getElementsByClass("hide");
				
				for (Element element : hideELES) {
					Elements contentELES=element.getElementsByClass("content");
					
					if (contentELES.size()>0) {
						
						String detail=contentELES.get(0).toString();
						Pattern pattern = Pattern.compile(directorRegx);
						Matcher matcher = pattern.matcher(detail);
						matcher.find();
						
						String director=matcher.group(0);
						director=director.replaceAll("<span>导演：</span>", "");
						director=director.replaceAll("</p>", "");
						
						movie.setDirector(director);
						
						
						pattern = Pattern.compile(starRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String stars=matcher.group(0);
						stars=stars.replaceAll("<span>主演：</span>", "");
						stars=stars.replaceAll("</p>", "");
						
						ArrayList<String> starslist=new ArrayList<String>();
						String[] reStrings=stars.split(",");
						for (String string : reStrings) {
							starslist.add(string);
						}
						
						movie.setStars(starslist);
						
						
						
						pattern = Pattern.compile(introRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String intro=matcher.group(0);
						intro=intro.replaceAll("<span>剧情：</span>", "");
						intro=intro.replaceAll("</p>", "");
						movie.setIntro(intro);
						
						
						pattern = Pattern.compile(countryRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String country=matcher.group(0);
						country=country.replaceAll("<span>地区：</span>", "");
						country=country.replaceAll("</p>", "");
						movie.setCountry(country);
						
						
						pattern = Pattern.compile(durationRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String duration=matcher.group(0);
						duration=duration.replaceAll("<span>片长：</span>", "");
						duration=duration.replaceAll("</p>", "");
						movie.setDuration(duration);

						
						pattern = Pattern.compile(startDateRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String startdate=matcher.group(0);
						startdate=startdate.replaceAll("<span>上映时间：</span>", "");
						startdate=startdate.replaceAll("</p>", "");
						movie.setStartDate(startdate);

					}
					
				}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
		
	}
	
	
	private  ArrayList<NuoMiMovie> getTheaterAndPriceInfo(ArrayList<NuoMiMovie> movies){
		WebClient webclient=new WebClient();
		HtmlPage page;
		
		
		
		
		for (NuoMiMovie nuoMiMovie : movies) {
			ArrayList<Ticket> tickets=new ArrayList<>();
			
			System.out.println("getting   "+nuoMiMovie.getName());
			
			System.out.println("getting   "+nuoMiMovie.getDetailLink());
			
		
		
		try {
			page = webclient.getPage(nuoMiMovie.getDetailLink());
			webclient.waitForBackgroundJavaScript(50000);
			
			
			DomElement btn=page.getElementById("moreCinema");
			
			if(btn==null){
				continue;
			}
			
			
			while(!btn.getTextContent().contains("没有")){
				btn.click();
				webclient.waitForBackgroundJavaScript(50000);
				btn=page.getElementById("moreCinema");
				
			}
			
			DomElement list=page.getElementById("pageletCinemalist");
			
			
			DomNodeList<HtmlElement> listitems=list.getElementsByTagName("li");
			
			
			
			for(int i=0;i<listitems.getLength();i++ ){
				
				
				Ticket ticket=parseTicketli(listitems.get(i));
				
				tickets.add(ticket);
			}
			
			nuoMiMovie.setTicketlist(tickets);
			
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		
		return movies;
	}
	
	private Ticket parseTicketli(HtmlElement liELE){
		
		Ticket ticket=new Ticket();
		
		String doc=liELE.asText();
		
		String[] reStrings=doc.split("\n");
		
		ticket.setTheaterName(reStrings[0]);
		
		ticket.setAddress(reStrings[1]);
		
		String priceTag=reStrings[reStrings.length-1];
		
		priceTag=priceTag.replaceAll("￥", "");
		priceTag=priceTag.replaceAll("起", "");
		try {
		double price=Double.parseDouble(priceTag);
		
		ticket.setPrice(price);
		}catch (Exception e) {
			System.out.println("This cinema has no price,thus,set to 0");
			System.out.println(doc);
			ticket.setPrice(0);
		}
		
		return ticket;
	}
	
	
	
	private  ArrayList<NuoMiMovieComingSoon> getMovieLinkFromNuoMiComingSoon(Element httpelement) {
		Elements lilist=httpelement.getElementsByClass("item");		
		String idregx="\\{(.*?)\\}";
		ArrayList<NuoMiMovieComingSoon> movies=new ArrayList<NuoMiMovieComingSoon>();
		
		
		for(Element li : lilist){
			NuoMiMovieComingSoon movie=new NuoMiMovieComingSoon();
			Pattern pattern = Pattern.compile(idregx);
			
			Matcher matcher = pattern.matcher(li.toString());
			
			
			matcher.find();
			
			String aString=matcher.group(0);
			
			aString=aString.replaceAll("\\{&quot;movieId&quot;:", "");
			
			aString=aString.replaceAll("\\}", "");
			
			movie.setDetailLink(movieDetailPrefix+aString+"&&cityId=315");
			
			movies.add(movie);
		}
		
		return movies;	
	}
	
	
	private  ArrayList<NuoMiMovieComingSoon> getMovieDetailComingSoon(ArrayList<NuoMiMovieComingSoon> movies){
		
		try {
		for (NuoMiMovieComingSoon movie : movies) {
				Document doc = Jsoup.connect(movie.getDetailLink()).get();
				Elements h4tags=doc.getElementsByTag("h4");
				
				String preTitle=h4tags.get(0).toString();
				
				String name=preTitle.replaceAll("<h4 class=\"subtitle\">", "");
				
				name=name.replaceAll("</h4>", "");
				movie.setName(name);
				////get MOVIE NAME
				
				
				
				
				
				////get Rank
				
				Elements rankELEs=doc.getElementsByClass("nuomi-orange font16 fl num");
				String rankELE=rankELEs.get(0).toString();
				rankELE=rankELE.replaceAll("<span class=\"nuomi-orange font16 fl num\">", "");
				rankELE=rankELE.replaceAll("</span>", "");
				
				movie.setRank(rankELE);
				
				String directorRegx="<span>导演：</span>(.*?)</p>";
				String starRegx="<span>主演：</span>(.*?)</p>";
				String introRegx="<span>剧情：</span>(.*?)</p>";
				String countryRegx="<span>地区：</span>(.*?)</p>";
				String durationRegx="<span>片长：</span>(.*?)</p>";
				String startDateRegx="<span>上映时间：</span>(.*?)</p>";
				
				
				Elements hideELES=doc.getElementsByClass("hide");
				
				for (Element element : hideELES) {
					Elements contentELES=element.getElementsByClass("content");
					
					if (contentELES.size()>0) {
						
						String detail=contentELES.get(0).toString();
						Pattern pattern = Pattern.compile(directorRegx);
						Matcher matcher = pattern.matcher(detail);
						matcher.find();
						
						String director=matcher.group(0);
						director=director.replaceAll("<span>导演：</span>", "");
						director=director.replaceAll("</p>", "");
						
						movie.setDirector(director);
						
						
						pattern = Pattern.compile(starRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String stars=matcher.group(0);
						stars=stars.replaceAll("<span>主演：</span>", "");
						stars=stars.replaceAll("</p>", "");
						
						ArrayList<String> starslist=new ArrayList<String>();
						String[] reStrings=stars.split(",");
						for (String string : reStrings) {
							starslist.add(string);
						}
						
						movie.setStars(starslist);
						
						
						
						pattern = Pattern.compile(introRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String intro=matcher.group(0);
						intro=intro.replaceAll("<span>剧情：</span>", "");
						intro=intro.replaceAll("</p>", "");
						movie.setIntro(intro);
						
						
						pattern = Pattern.compile(countryRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String country=matcher.group(0);
						country=country.replaceAll("<span>地区：</span>", "");
						country=country.replaceAll("</p>", "");
						movie.setCountry(country);
						
						
						pattern = Pattern.compile(durationRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String duration=matcher.group(0);
						duration=duration.replaceAll("<span>片长：</span>", "");
						duration=duration.replaceAll("</p>", "");
						movie.setDuration(duration);

						
						pattern = Pattern.compile(startDateRegx);
						matcher = pattern.matcher(detail);
						matcher.find();
						String startdate=matcher.group(0);
						startdate=startdate.replaceAll("<span>上映时间：</span>", "");
						startdate=startdate.replaceAll("</p>", "");
						movie.setStartDate(startdate);

					}
					
				}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
		
	}
	
}
