package pl.springapp.tasks;

import javax.inject.Named;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@SomeService("nazwa serwisu")
@Component
public class TaskService {

        public String getServiceId() {
                return "taskService#1";
        }
}

