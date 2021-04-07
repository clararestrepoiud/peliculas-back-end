package co.edu.iudigital.app.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.model.entity.Movie;
import co.edu.iudigital.app.model.repository.GenderRepository;
import co.edu.iudigital.app.model.repository.MoviesRepository;
import co.edu.iudigital.app.service.iface.MovieService;

//no se puede olvidar, como es un servicio anotarlo como tal
@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MoviesRepository movieRepository;

	//esto lo debemos inyectar porque la creacion de peliculas depende de gender
	//no puedeo crear una pelicula con un genero q no exista
	
	@Autowired
	private GenderRepository genderRepository;
	
	@Override
	public List<Movie> getall() {
		// aqui declaro un atributo que sea una lista de peliculas
		List<Movie> movies = new ArrayList<>();
		//y ahora voy a retornar esa lista de peliculas
		movies=(List<Movie>) movieRepository.findAll();
		// aqui retorno la lista de las peliculas
		return movies;
	}

	@Override
	public void create(Movie movie) {
		// primero reviso que el genero existe con el sgte metodo
		
		boolean existsGender = genderRepository.existsById(movie.getGenderId().getId());
		
		//si ese genero existe, entonces puede crear la pelicula
		
		if(existsGender) {
			
			movie.setCreateAt(LocalDateTime.now());
			movieRepository.save(movie);
		}
		
	}

	@Override
	public void edit(Movie movie, int movieId) {
		// primero verifico que la pelicula existe para poder editarla
		Optional<Movie> existsMovie = movieRepository.findById(movieId);
		if(existsMovie.isPresent()) {
			existsMovie.get().setName(movie.getName());
			existsMovie.get().setDescription(movie.getDescription());
			existsMovie.get().setActors(movie.getActors());
			existsMovie.get().setImage(movie.getImage());
			existsMovie.get().setRating(movie.getRating());
			existsMovie.get().setReleaseDate(movie.getReleaseDate());
			
			boolean existsGender = genderRepository.existsById(movie.getGenderId().getId());
			if(existsGender) {
				existsMovie.get().setGenderId(movie.getGenderId());
				
			}
			movieRepository.save(existsMovie.get());
		}
		
	}

	@Override
	public void delete(int movieId) {
		// primero verifico que exista la pelicula
		Optional<Movie> existsMovie = movieRepository.findById(movieId);
		if(existsMovie.isPresent()) {
			movieRepository.delete(existsMovie.get());
		}
		
	}

	@Override
	public void rate(Movie movie, int movieId) {
		Optional<Movie> existsMovie = movieRepository.findById(movieId);
		if(existsMovie.isPresent()) {
			existsMovie.get().setRating(existsMovie.get().getRating()+movie.getRating());
			movieRepository.save(existsMovie.get());
		}
		
		
	}

}



















