package DAO;


import Bean.Jdonsale;

public interface JDOnSaleDao{

	public void save(Jdonsale jDOnSale);

	public Jdonsale findByMovieName(String movieName);
}
