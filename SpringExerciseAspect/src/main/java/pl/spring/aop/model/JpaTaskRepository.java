package pl.spring.aop.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class JpaTaskRepository implements TaskRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveTask(Task task) {
		entityManager.persist(task);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public void readTask(int idTask) {
//		throw new NullPointerException(); //when we need check AOP @Around 
		Task find = entityManager.find(Task.class, idTask);
		System.out.println(find);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Task> readAllTasks() {
		Query createQuery = entityManager.createQuery("from Task");
		return createQuery.getResultList();
	}

}
