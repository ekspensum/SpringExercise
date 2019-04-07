package pl.springapp.tasks;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class SecondTaskService implements SomeService {

        @Override
        public String getMessage() {
                // TODO Auto-generated method stub
                return "Hello world! - from SecondTaskService";
        }

}
