package pl.spring.exercise.autowired.model;

public class Task {

        private int id;

        public Task(int id) {
                super();
                this.id = id;
        }

        @Override
        public String toString() {
                return "From autowired config, task [id=" + id + "]";
        }

}

