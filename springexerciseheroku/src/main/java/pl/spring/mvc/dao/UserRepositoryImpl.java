package pl.spring.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.mvc.entity.Role;
import pl.spring.mvc.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveUser(User user, int idRole1, int idRole2) {
		try {
			Role firstRole = new Role();
			firstRole.setId(idRole1);
			Role secondRole = new Role();
			secondRole.setId(idRole2);
			List<Role> roles = new ArrayList<>();
			roles.add(firstRole);
			roles.add(secondRole);
			user.setRoles(roles);
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPasswordField()));
			entityManager.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Role> fetchAllRoles() {
		List<Role> resultList = entityManager.createNamedQuery("fetchAllRoles", Role.class).getResultList();
		return resultList;
	}

}
