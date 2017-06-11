package DAO;


import Bean.*;;

public interface NuoMiMovieDao{
	public void save(Nuomimovie nuoMiMovie);
	
	public Nuomimovie findByMovieName(String movieName);

}
