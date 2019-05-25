package pl.spring.mvc.dao;

import java.util.List;

import pl.spring.mvc.entity.Role;
import pl.spring.mvc.entity.User;

public interface UserRepository {

	boolean saveUser(User user, int idRole1, int idRole2);
	List<Role> fetchAllRoles(); 
}
