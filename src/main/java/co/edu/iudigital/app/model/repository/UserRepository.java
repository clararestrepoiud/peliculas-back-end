package co.edu.iudigital.app.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.iudigital.app.model.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	//aca debo agregar este metodo porque en UserServiceImpl el metodo de login no reconoce este metodo, pues no lo conoce
	
	//este metodo es abstracto
	public User findByEmailAndPassword(String email, String password);
	

}
