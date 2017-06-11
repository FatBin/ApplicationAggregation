package Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author peiyulin
 *  每个 ticket 表示一个电影的一个电影院的售价，电影院名称，位置
 */


@Entity
@Table(name="Ticket")
public class Ticket {
	@Id
	private int id;
	private String movieName;
	private String theaterName;
	private double price;
	private String address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		String reString="name: "+theaterName+"\n"
				+"address:"+address+"\n"
				+"price:"+price+"\n"
				+"--------------------------";
		
		return reString;
	}
	
	

}
