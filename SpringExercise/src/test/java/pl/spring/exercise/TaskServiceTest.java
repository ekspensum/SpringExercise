package pl.spring.exercise;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.exercise.autowired.config.ConfigApp;
import pl.spring.exercise.autowired.service.ToDoListStrategy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfigApp.class)
public class TaskServiceTest {
	
	@Autowired
	@Qualifier("default")
	private ToDoListStrategy doListStrategy;

	@Test
	public void test() {
		assertNotNull(doListStrategy);
	}

}
