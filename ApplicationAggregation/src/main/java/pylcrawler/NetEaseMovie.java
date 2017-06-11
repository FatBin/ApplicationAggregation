package pylcrawler;

import java.util.ArrayList;

public class NetEaseMovie {
	private String name;// 电影名
	private ArrayList<String> stars=new ArrayList<String>(); // 主演列表
	private String intro;     //简介
	private String director; // 导演
	private String rank="no rank";// 点评分数
	private String startDate; // 上映时间
	
	
	private ArrayList<NuoMiTicket> ticketlist; 
	
	
	
	
	
	public ArrayList<NuoMiTicket> getTicketlist() {
		return ticketlist;
	}
	public void setTicketlist(ArrayList<NuoMiTicket> ticketlist) {
		this.ticketlist = ticketlist;
	}
	public String getName() {
		return name;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	
	
}
