package pl.spring.exercise.xmlconfig.model;

public class Task {

        private int id;

        public Task(int id) {
                super();
                this.id = id;
        }

        @Override
        public String toString() {
                return "From xml config, task [id=" + id + "]";
        }

}

