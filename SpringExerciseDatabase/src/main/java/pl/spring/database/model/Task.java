package pl.spring.database.model;

import java.time.LocalDateTime;

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
	
	public TaskBuilder New() {
		return new TaskBuilder();
	}
	
	public static class TaskBuilder {
		
		private Task task;
		
		public TaskBuilder() {
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
