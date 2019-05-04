package pl.spring.mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.mvc.model.Task;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean saveTask(Task task) {
		try {
			entityManager.persist(task);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Task> readAllTasks() {
		return entityManager.createQuery("from Task").getResultList();
	}

}
