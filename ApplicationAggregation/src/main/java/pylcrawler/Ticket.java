package pylcrawler;
/**
 * 
 * @author peiyulin
 *  每个 ticket 表示一个电影的一个电影院的售价，电影院名称，位置
 */


public class Ticket {
	private String theaterName;
	private double price;
	private String address;
	
	
	
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
