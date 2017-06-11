package DAO;


import java.util.List;

import Bean.Ticket;

public interface TicketDao{

	public void save(Ticket ticket);
	
	public List<Ticket> find(String movieName, String theater, String date);
}
