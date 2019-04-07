package pl.spring.exercise.xmlconfig.service;

import java.util.List;

import pl.spring.exercise.xmlconfig.model.Task;

public class TaskService {

        private List<ToDoListStrategy> doListStrategies;

        public TaskService() {
                super();
        }

        public TaskService(List<ToDoListStrategy> doListStrategies) {
                super();
                this.doListStrategies = doListStrategies;
        }

        public void setDoListStrategies(List<ToDoListStrategy> doListStrategies) {
                this.doListStrategies = doListStrategies;
        }

        public List<Task> findCurrentToDoList(int idStrategy){
                return doListStrategies.get(idStrategy).creteToDoList();
        }
}

