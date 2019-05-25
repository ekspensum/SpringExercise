package pl.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.mvc.dao.UserRepository;
import pl.spring.mvc.entity.Role;
import pl.spring.mvc.entity.User;

@Service
public class UserRegisterService {

	@Autowired
	private UserRepository userRepository;

	public boolean addUser(User user, int idRole1, int idRole2) {
		if (userRepository.saveUser(user, idRole1, idRole2)) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Role> getAllRoles(){
		List<Role> fetchAllRoles = userRepository.fetchAllRoles();
		return fetchAllRoles;
	}
}
