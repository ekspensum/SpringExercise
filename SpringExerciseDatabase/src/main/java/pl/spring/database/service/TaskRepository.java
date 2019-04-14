package pl.spring.database.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import pl.spring.database.model.Task;

@Repository
public class TaskRepository {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert taskInsert;
	
	@Autowired
	public TaskRepository(DataSource dataSource) throws SQLException {
		jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		taskInsert = new SimpleJdbcInsert(dataSource).withTableName("task");
	}

	public void saveTask(Task task) {
		jdbcTemplate.update("INSERT INTO task VALUES(?,?,?,?)", null, task.getSubject(), task.getDateTimeStart(), task.getDateTimeEnd());
	}
	
	public void saveTaskSeconApproach(Map<String, Object> propertiesMap) {
		taskInsert.execute(propertiesMap);
	}
	
	public void readTask(int idTask) {
		SqlRowSet queryForRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM task WHERE id = "+idTask+"");
		queryForRowSet.next();
		System.out.println(queryForRowSet.getInt(1)+" "+queryForRowSet.getString(2)+" "+queryForRowSet.getDate(3)+" "+queryForRowSet.getTime(3)+" "+queryForRowSet.getDate(4)+" "+queryForRowSet.getTime(4));
	}
	
	public List<Task> readAllTasks(){
		return jdbcTemplate.query("SELECT * FROM task", new TaskMapper());
	}
	
	public class TaskMapper implements RowMapper<Task> {

		@Override
		public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
			Task task = new Task().New()
					.withId(rs.getInt(1))
					.withSubject(rs.getString(2))
					.startOn(LocalDateTime.parse(rs.getDate(3)+"T"+rs.getTime(3)))
					.endOn(LocalDateTime.parse(rs.getDate(4)+"T"+rs.getTime(4)))
					.build();
			return task;
		}
		
	}
}
