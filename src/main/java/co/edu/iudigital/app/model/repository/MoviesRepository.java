package co.edu.iudigital.app.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.app.model.entity.Movies;

public interface MoviesRepository extends CrudRepository<Movies, Integer>{

}
