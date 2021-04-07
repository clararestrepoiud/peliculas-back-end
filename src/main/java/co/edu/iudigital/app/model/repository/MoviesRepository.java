package co.edu.iudigital.app.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.app.model.entity.Movie;

public interface MoviesRepository extends CrudRepository<Movie, Integer>{

}
