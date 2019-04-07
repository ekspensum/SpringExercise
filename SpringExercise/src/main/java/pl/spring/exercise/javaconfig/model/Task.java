package pl.spring.exercise.javaconfig.model;

public class Task {

    private Long id;

    public Task(Long id) {
            super();
            this.id = id;
    }

    @Override
    public String toString() {
            // TODO Auto-generated method stub
            return "Task no "+id ;
    }


}

