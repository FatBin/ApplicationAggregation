package XMLBean;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lhl
 *
 */
@XmlRootElement
@Entity
@Table(name="AllMovie")
public class All {
	@Id
	private String moviename;//电影名
	private double score;//评分
	private Actor actor=new Actor();//主演
	private String director;//导演
	private String tag;//标签
	private String introduction;//介绍
	private String detailLink;//详细链接，一般指向购票界面
	private String country;// 国家
	private String duration; // 时长
	private String startDate; // 首映日期，如“2017-07-06”
	private String date; // 电影票上的日期
	private String begin; // 开始时间，几点钟
	private String end; // 结束时间，几点钟
	private String theater; // 电影院
	private String hall; // 放映厅
	private double price; // 票价
	private String sponser; // 赞助商
	private String language; // 语言
	private String address; // 电影院地址
	
	@XmlElement
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	@XmlElement
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@XmlElement
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actors) {
		this.actor = actors;
	}
	@XmlElement
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@XmlElement
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@XmlElement
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@XmlElement
	public String getDetailLink() {
		return detailLink;
	}
	public void setDetailLink(String detailLink) {
		this.detailLink = detailLink;
	}
	@XmlElement
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@XmlElement
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@XmlElement
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	@XmlElement
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@XmlElement
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	@XmlElement
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@XmlElement
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	@XmlElement
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	@XmlElement
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@XmlElement
	public String getSponser() {
		return sponser;
	}
	public void setSponser(String sponser) {
		this.sponser = sponser;
	}
	@XmlElement
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@XmlElement
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
		
	
}
