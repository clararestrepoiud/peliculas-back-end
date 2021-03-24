package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.model.entity.Gender;
import co.edu.iudigital.app.model.repository.GenderRepository;
import co.edu.iudigital.app.service.iface.GenderService;

//service es un caso particular o un tipo de component

@Service
public class GenderServiceImpl implements GenderService{

	//esto es para hacer inyeccion de dependecnias mediante un atributo, para inyectar lo que esta en repostitory aca
	@Autowired
	private GenderRepository genderRepository;
	
	//gracias a que genderRepository extends crud repository es que se puede usar el metodo findall
	
	public List<Gender>getAll(){
		// TODO Auto-generated method stub
		List<Gender> genders = new ArrayList<>();	
		genders = (List<Gender>) genderRepository.findAll();
		return genders;		

	}

}
