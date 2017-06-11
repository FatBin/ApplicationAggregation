package lxbincrawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mm on 2017/6/11.
 */
public class SPIDERMovieCrawler {
    public String[] HomePage={"https://film.spider.com.cn/nj-film----","/"};
    public static void main(String [] args){
        SPIDERMovieCrawler SPIDERMovieCrawler=new SPIDERMovieCrawler();
        SPIDERMovieCrawler.process();
    }

    public void process(){
        ArrayList<String> url= getAllMovieURLs();
    }

    public ArrayList<String> getAllMovieURLs(){
        try {
            Document document= Jsoup.connect("http://film.spider.com.cn/film-201706564606/").get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<3;i++){

        }

        return null;
    }
}
