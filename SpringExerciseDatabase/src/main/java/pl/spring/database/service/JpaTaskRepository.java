package pl.spring.database.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pl.spring.database.model.Task;

@Repository
@RepositoryQualifier(type=RepositoryType.JPA)
public class JpaTaskRepository implements TaskRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveTask(Task task) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveTaskSeconApproach(Map<String, Object> propertiesMap) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readTask(int idTask) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> readAllTasks() {
		Query createQuery = entityManager.createQuery("from Task");
		return createQuery.getResultList();
	}

}
