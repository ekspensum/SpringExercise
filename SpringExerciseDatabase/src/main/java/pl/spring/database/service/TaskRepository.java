package pl.spring.database.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import pl.spring.database.model.Task;

@Repository
public class TaskRepository {

	JdbcTemplate jdbcTemplate;
	SimpleJdbcInsert taskInsert;
	
	@Autowired
	public TaskRepository(DataSource dataSource) throws SQLException {
		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		taskInsert = new SimpleJdbcInsert(dataSource).withTableName("task");
	}

	public void saveTask(Task task) {
		jdbcTemplate.update("INSERT INTO task VALUES(?,?,?,?)", null, task.getSubject(), task.getDateTimeStart(), task.getDateTimeEnd());
	}
	
	public void saveTaskSeconApproach(Task task) {
		Map<String, Object> taskMap = new HashMap<>();
		taskMap.put("subject", task.getSubject());
		taskMap.put("dateStart", task.getDateTimeStart());
		taskMap.put("dateEnd", task.getDateTimeEnd());
		taskInsert.execute(taskMap);
	}
	
	public void readTask(int idTask) {
		SqlRowSet queryForRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM task WHERE id = "+idTask+"");
		queryForRowSet.next();
		System.out.println(queryForRowSet.getInt(1)+" "+queryForRowSet.getString(2)+" "+queryForRowSet.getDate(3)+" "+queryForRowSet.getTime(3)+" "+queryForRowSet.getDate(4)+" "+queryForRowSet.getTime(4));
	}
}
