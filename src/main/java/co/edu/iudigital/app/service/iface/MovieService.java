package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.model.entity.Movie;

public interface MovieService {
	
	/**
	 * Obtener todas las peliculas
	 * @return
	 */
	public List<Movie> getall();
	/**
	 * crea una pelicula
	 * @param movie
	 */
	public void create(Movie movie);
	
	/**
	 * edita pelicula por su id
	 * @param movie
	 * @param movieId
	 */
	public void edit (Movie movie, int movieId);
	
	/**
	 * bora una pelicula por su id
	 * @param movieId
	 */
	public void delete(int movieId);
	
	/**
	 * califica una pelicula por su id
	 * @param movie
	 * @param movieId
	 */
	public void rate(Movie movie, int movieId);
	
	

}
