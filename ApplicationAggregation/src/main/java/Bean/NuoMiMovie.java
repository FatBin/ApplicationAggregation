package Bean;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="NetEaseMovie")
public class NuoMiMovie {
	@Id
	private String name;// 电影名
	private ArrayList<String> stars=new ArrayList<String>(); // 主演列表
	private String intro;     //简介
	private String detailLink; // 详细链接 一般指向购票界面
	private String director; // 导演
	private String rank="no rank";// 点评分数
	private String country;// 国家
	private String duration; // 时长
	private String startDate; // 上映时间
	
	private ArrayList<Ticket> ticketlist; 
	

	
	
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getDetailLink() {
		return detailLink;
	}
	public void setDetailLink(String detailLink) {
		this.detailLink = detailLink;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public ArrayList<String> getStars() {
		return stars;
	}
	public void setStars(ArrayList<String> stars) {
		this.stars = stars;
	}
	
	
	public String getIntro() {
		return intro;
	}
	
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
	public ArrayList<Ticket> getTicketlist() {
		return ticketlist;
	}
	public void setTicketlist(ArrayList<Ticket> ticketlist) {
		this.ticketlist = ticketlist;
	}
	
	@Override
	public String toString() {
		
		String starlist=stars.toString();
		String reString="movie name:"+name+"\n"
				+"stars:"+starlist+"\n"
				+"intro:"+intro+"\n"
				+"director:"+director+"\n"
				+"country:"+country+"\n"
				+"durartion:"+duration+"\n"
				+"startDate:"+startDate+"\n"+
				"rank:"+rank+"\n"+
				"----------------Ticket 用 getTicketlist 查看---------------\n";
		
		return reString;
				
	}
	
	
}
