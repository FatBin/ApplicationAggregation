package pylcrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;



public class NetEaseMovieGetter {
	
	private static String urlPrefix="http://piao.163.com/nanjing/movie/";
	
	public ArrayList<NetEaseMovie> getNetEaseMovieIsON(){
		ArrayList<String> linklist = getAllMovieLinkisON();
		ArrayList<NetEaseMovie> movies=new ArrayList<>();
		
		WebClient webclient=new WebClient();
		HtmlPage page;
		
		try {
		
		for (String string : linklist) {
			NetEaseMovie movie=new NetEaseMovie();
			page = webclient.getPage(string);
			webclient.waitForBackgroundJavaScript(50000);
			
			List<HtmlElement> nodes=page.getByXPath("//span[@class='mv_name']");
			
			movie.setName(nodes.get(0).asText());
			System.out.println(nodes.get(0).asText());
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		return null;
	}
	
	
	
	private ArrayList<String> getAllMovieLinkisON(){
		ArrayList<String> linklist=new ArrayList<>();
		WebClient webclient=new WebClient();
		HtmlPage page;
		
		String linkregX="href=\"(.*?)\"";
		
		try {
			page = webclient.getPage("http://piao.163.com/movie/onshow.html?isTable=0");
			webclient.waitForBackgroundJavaScript(50000);
			List<HtmlElement> nodes=page.getByXPath( "//div[@class='showImg']");
			
			
			for (HtmlElement htmlElement : nodes) {
			
				
				DomNodeList atags=htmlElement.getElementsByTagName("a");
				
				DomNode aNode=(DomNode) atags.get(0);
				
				Pattern pattern = Pattern.compile(linkregX);
				Matcher matcher = pattern.matcher(aNode.asXml());
				
				matcher.find();
				
				String[] reStrings=matcher.group(0).split("/");
				
				String linkid=reStrings[3];
				linkid=linkid.replaceAll("\"", "");
				
				String link=urlPrefix+linkid;
				
				linklist.add(link);
				
			}
			
			
			
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
		
		return linklist;
	}
}
