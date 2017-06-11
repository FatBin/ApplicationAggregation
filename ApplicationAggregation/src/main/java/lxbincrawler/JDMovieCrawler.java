package lxbincrawler;

import Bean.Jdonsale;
import DAO.JDOnSaleDao;
import DaoImpl.JDOnSaleDaoImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by mm on 2017/6/10.
 */
public class JDMovieCrawler {
    String homepage="http://movie.jd.com/index.html";
    String detail="http://movie.jd.com";
    String[] cinema={"http://movie.jd.com/json/seat/seat_movieIssue.action?cityId=3201&movieId=","&day="};
    String[]  data={"https://movie.jd.com/json/seat/seat_buy.action?cityId=3201&movieId=","&day=","&cinemaId="};
    public ArrayList<JDTicket> process(){
        JDOnSaleDao jdOnSaleDao=new JDOnSaleDaoImpl();
        JDMovieCrawler jd=new JDMovieCrawler();
        ArrayList<JDOnSale> arrayList=jd.getOnSaleFromHomepage();
        for (JDOnSale jdOnSale:arrayList
             ) {
            jd.getDetail(jdOnSale);
            System.out.println(jdOnSale.getMovieName()+" "+jdOnSale.getDirector()+" "+jdOnSale.getTimes().size());
        }


        ArrayList<JDTicket> result=new ArrayList<>();
        for(JDOnSale jdOnSale:arrayList){
            ArrayList<String > times=jdOnSale.getTimes();
            for(String time:times){
                ArrayList<JDTicket> tempArray=new ArrayList<>();//记录某天的某电影可用电影院

                String movieName=jdOnSale.getMovieName();
                String movieId=jdOnSale.getMovieId().substring(3);
                String date=time;
                String temp=jd.httpRequest(jd.cinema[0]+movieId+jd.cinema[1]+date);
                String js=temp.substring(5,temp.length()-3);
                JSONObject jsonObject=new JSONObject(js);
                JSONArray jsonArray=jsonObject.getJSONArray("cinemaData");
                for (int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject t=jsonArray.getJSONObject(i);
                        String Theater=t.getString("pname");
                        int TheaterId=t.getInt("pid");
                        JDTicket jdTicket=new JDTicket();
                        jdTicket.setMovie(movieName);
                        jdTicket.setMovieId(movieId);
                        jdTicket.setTheater(Theater);
                        jdTicket.setTheaterId(TheaterId);
                        jdTicket.setDate(date);
                        tempArray.add(jdTicket);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }


                for (JDTicket ticket:tempArray
                        ) {
                    result.addAll(jd.getDetails(ticket));
                }
            }
        }
            return result;

    }




    public ArrayList<JDTicket> getDetails(JDTicket ticket) {
        ArrayList<JDTicket> result=new ArrayList<>();
        String url=data[0]+ticket.getMovieId()+data[1]+ticket.getDate()+data[2]+ticket.getTheaterId();
        System.out.println(url);
        String httpRequest=httpRequest(url);
        JSONObject jsonObject=new JSONObject(httpRequest.substring(5,httpRequest.length()-3));
        JSONArray jsonArray=jsonObject.getJSONArray("showData");
        for (int i=0;i<jsonArray.length();i++){
            try{
                JSONObject jo=jsonArray.getJSONObject(i);
                JDTicket j=new JDTicket();
                j.setTheater(ticket.getTheater());
                j.setTheaterId(ticket.getTheaterId());
                j.setMovieId(ticket.getMovieId());
                j.setMovie(ticket.getMovie());
                j.setDate(ticket.getDate());
                j.setBegin(jo.getString("ptime"));
                j.setEnd(jo.getString("pendtime"));
                j.setLanguage(jo.getString("ptype"));
                j.setHall(jo.getString("pseat"));
                j.setPrice(jo.getString("pprice"));
                j.setSponsor(jo.getString("pagent"));
                System.out.println(j.getMovie()+" "+j.getMovieId()+" "+j.getTheater()+" "+j.getTheaterId()+" "+j.getDate()
                        +" "+j.getBegin()+" "+j.getEnd()+" "+j.getLanguage()+" "+j.getHall()+" "+j.getPrice()+" "+j.getSponsor());
                result.add(j);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(httpRequest);
        return result;
    }

    public String httpRequest(String target){
        String result="";
        try {
            URL url = new URL(target);
            URLConnection urlConnection = url.openConnection(); // 打开连接

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "gbk")); // 获取输入流
            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            br.close();
            result=sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<JDOnSale> getOnSaleFromHomepage(){
        ArrayList<JDOnSale> arrayList=new ArrayList<JDOnSale>();
        try {
            Document document=Jsoup.connect(homepage).get();
            Element t1=document.getElementsByAttributeValue("data-wiget","spin-item").first();
            Elements t2=t1.select("dd");
            for (Element temp:t2
                 ) {
                try{
                    String movieId=temp.select("div[class=p-img]").first().select("a").first().attr("href");
                    String movieName=temp.select("div[class=p-info]").first().select("a").text();
                    double score=0;
                    try{
                        score=Double.valueOf(temp.select("div[class=p-score]").text());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    JDOnSale jdPlayingHomepage=new JDOnSale();
                    jdPlayingHomepage.setMovieId(movieId);
                    jdPlayingHomepage.setMovieName(movieName);
                    jdPlayingHomepage.setScore(score);
                    arrayList.add(jdPlayingHomepage);
                }catch (Exception e){
                    e.printStackTrace();
                }
//                System.out.println(movieId+" "+movieName+" "+score);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void getDetail(JDOnSale jdOnSale){
        String url=detail+jdOnSale.getMovieId();
        try {
            Document document=Jsoup.connect(url).get();
            String director=document.select("dd[class=movie-director]").select("div[class=infor]").text();//导演
            ArrayList<String> actors=new ArrayList<String>();//演员
            Elements aes=document.select("dd[class=movie-photo js-movie-phone-star]").select("div[class=name]");
            for (Element element:aes){
                actors.add(element.text());
            }
            String tag=document.select("dd[class=movie-type]").text();//标签
            String introduction=document.select("dd[class=movie-intro js-plot-short-infor]").select("p").text();//介绍
            jdOnSale.setDirector(director);
            jdOnSale.setActors(actors);
            jdOnSale.setTag(tag);
            jdOnSale.setIntroduction(introduction);

            ArrayList<String> times=new ArrayList<String>();//可选时间
            Elements tes=document.getElementsByAttributeValue("id","chooseDay").select("a");
            for (Element element:tes
                 ) {
                times.add(element.attr("vid"));
            }

            jdOnSale.setTimes(times);
//            System.out.println(times.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
