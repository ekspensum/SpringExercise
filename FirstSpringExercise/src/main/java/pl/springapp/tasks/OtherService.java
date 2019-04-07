package pl.springapp.tasks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//This component is declare in app-context.xml file with scope = prototype
public class OtherService implements SomeService, InitializingBean, DisposableBean {

        @Override
        public String getMessage() {
                // TODO Auto-generated method stub
                return "Hello World! - from OtherService";
        }

        @PostConstruct
        public void initService() {
                System.out.println("Post construct");
        }

        @PreDestroy
        public void destroyService() {
                System.out.println("Pre destroy");
        }

        @Override
        public void destroy() throws Exception {
                System.out.println("InitializingBean - Post construct");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
                System.out.println("DisposableBean - Pre destroy");
        }

}

