package co.edu.iudigital.app.service.impl;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.model.entity.User;
import co.edu.iudigital.app.model.repository.ProfileRepository;
import co.edu.iudigital.app.model.repository.UserRepository;
import co.edu.iudigital.app.service.iface.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	private ProfileRepository profileRepository;
	
	
	@Override
	public void create(User user) {
		//TODO: implementar		
		
		//verifico que la llave foranea exista profileid
		boolean existsProfileID = userRepository.existsById(user.getProfileId().getId());
		
		if(existsProfileID) {
			user.setCreateAt(LocalDateTime.now());
			userRepository.save(user);
		}
	}
	
	@Override
	public User login(User user) throws Exception {
		User existsUser = userRepository
				.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(existsUser == null) {
			throw new Exception("Usuario y/o contraseña invalido!");
		}
		return existsUser;
	}


}