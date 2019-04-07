package pl.spring.exercise.javaconfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import pl.spring.exercise.javaconfig.model.Task;

public class TaskService {

//      @Autowired
//      @Qualifier
        private ToDoListStrategy doListStrategy;

        @Autowired
        @Qualifier("array")
        private ToDoListStrategy [] doListStrategyArray;

        public TaskService() {
                super();
        }

//      @Autowired(required = true)
        public TaskService(ToDoListStrategy doListStrategy) {
                super();
                this.doListStrategy = doListStrategy;
        }

//      @Autowired
        public TaskService(ToDoListStrategy[] doListStrategyArray) {
                super();
                this.doListStrategyArray = doListStrategyArray;
        }

        public List<Task> findCurrentToDoList(){
                return doListStrategy.creteToDoList();
        }

        @Autowired
        @Qualifier
        public void setDoListStrategy(ToDoListStrategy doListStrategy) {
                this.doListStrategy = doListStrategy;
        }

        public List<Task> findCurrentToDoListArray(int idStrategy){
                return doListStrategyArray[idStrategy].creteToDoList();
        }

//      @Autowired
//      @Qualifier("array")
//      public void setDoListStrategyArray(ToDoListStrategy[] doListStrategyArray) {
//              this.doListStrategyArray = doListStrategyArray;
//      }



}

