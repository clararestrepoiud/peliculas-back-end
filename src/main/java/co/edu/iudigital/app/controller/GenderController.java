package co.edu.iudigital.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.model.entity.Gender;
import co.edu.iudigital.app.service.iface.GenderService;

//API application programming interface
//REST Representational state trasnfer

@RestController
//esto es para que el que le haga peticion a esta ruta es porque le quiere hacer una peticion a este controlador
@RequestMapping("/gender")
@CrossOrigin("*")
public class GenderController {
	//inyeccion de dependencias
	@Autowired
	private GenderService genderService;
	
	//el get mapping dice que la peticion de ese metodo es tipo get. tambien se puede put, post, delete
	@GetMapping
	public List<Gender> getAll(){
		return genderService.getAll();
	}
	

}
