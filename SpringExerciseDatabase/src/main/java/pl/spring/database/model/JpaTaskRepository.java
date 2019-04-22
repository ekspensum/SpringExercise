package pl.spring.database.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.database.service.RepositoryQualifier;
import pl.spring.database.service.RepositoryType;

@Repository
@RepositoryQualifier(type=RepositoryType.JPA)
public class JpaTaskRepository implements TaskRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveTask(Task task) {
		entityManager.persist(task);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveTaskSecondApproach(Map<String, Object> propertiesMap) {
		Task task = new Task().New()
		.withSubject(propertiesMap.get("subject").toString())
		.startOn(LocalDateTime.parse(propertiesMap.get("dateStart").toString()))
		.endOn(LocalDateTime.parse(propertiesMap.get("dateEnd").toString()))
		.build();
		entityManager.persist(task);
	}

	@Override
	public void readTask(int idTask) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Task> readAllTasks() {
		Query createQuery = entityManager.createQuery("from Task");
		return createQuery.getResultList();
	}

}
