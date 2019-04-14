package pl.spring.database.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Task {

	private int id;
	private String subject;
	private LocalDateTime dateTimeStart;
	private LocalDateTime dateTimeEnd;
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", subject=" + subject + ", dateTimeStart=" + dateTimeStart + ", dateTimeEnd="
				+ dateTimeEnd + "]";
	}
	
	public PropertiesMapBuilder newPropertiesMap() {
		return new PropertiesMapBuilder();
	}
	
	public static class PropertiesMapBuilder {
		private Map<String, Object> propertiesMap;

		private PropertiesMapBuilder() {
			this.propertiesMap = new HashMap<>();
		}
		
		public PropertiesMapBuilder withId(int id) {
			this.propertiesMap.put("id", id);
			return this;
		}
		public PropertiesMapBuilder withSubject(String subject) {
			this.propertiesMap.put("subject", subject);
			return this;
		}
		public PropertiesMapBuilder startOn(LocalDateTime dateTimeStart) {
			this.propertiesMap.put("dateStart", dateTimeStart);
			return this;
		}
		public PropertiesMapBuilder endOn(LocalDateTime dateTimeEnd) {
			this.propertiesMap.put("dateEnd", dateTimeEnd);
			return this;
		}
		public Map<String, Object> build(){
			return this.propertiesMap;
		}
	}
	
	public TaskBuilder New() {
		return new TaskBuilder();
	}
	
	public static class TaskBuilder {
		
		private Task task;
		
		private TaskBuilder() {
			this.task = new Task();
		}

		public TaskBuilder withId(int id) {
			task.id = id;
			return this;
		}	
		public TaskBuilder withSubject(String subject) {
			task.subject = subject;
			return this;
		}
		public TaskBuilder startOn(LocalDateTime dateTimeStart) {
			task.dateTimeStart = dateTimeStart;
			return this;
		}
		public TaskBuilder endOn(LocalDateTime dateTimeEnd) {
			task.dateTimeEnd = dateTimeEnd;
			return this;
		}
		public Task build() {
			return task;
		}
	}

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public LocalDateTime getDateTimeStart() {
		return dateTimeStart;
	}

	public LocalDateTime getDateTimeEnd() {
		return dateTimeEnd;
	}
	
	
}
