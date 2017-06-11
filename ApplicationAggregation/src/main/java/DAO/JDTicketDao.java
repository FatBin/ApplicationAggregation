package DAO;


import Bean.Jdticket;

import java.util.List;

public interface JDTicketDao{

	public void save(Jdticket jDTicket);

	public List<Jdticket> find(String movieName, String theater, String date);
}
