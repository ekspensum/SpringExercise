package pl.springapp.tasks;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import pl.springapp.tasks.configuration.AppConfig;

public class RunnerClass {

        public static void main(String[] args) {
                // TODO Auto-generated method stub

                BeanFactory factory = new XmlBeanFactory(new ClassPathResource("/META-INF/spring/app-context.xml"));
                String servString = factory.getBean(TaskService.class).getServiceId();
                System.out.println(servString);

//              This approach need to work add dependency for CGLIB library in pom.xml
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

                String serviceId = context.getBean(TaskService.class).getServiceId();
                System.out.println(serviceId);

                String exampleServiceMessage = context.getBean("exampleService", ExampleService.class).getMessage();
                System.out.println(exampleServiceMessage);

//              ApplicationContext - interface extend BeanFactory
                ApplicationContext secondContext = new ClassPathXmlApplicationContext("/META-INF/spring/app-context.xml");

                System.out.println(secondContext.getBean(SecondTaskService.class).getMessage());
                SecondTaskService firstService = secondContext.getBean(SecondTaskService.class);
                SecondTaskService secondService = secondContext.getBean(SecondTaskService.class);

                if(firstService == secondService)
                        System.out.println("Referances are the same"); //because default component state is SINGLETON
                else
                        System.out.println("References are different"); //when we change component state on PROTOTYPE (annotation: Scope with parameter value BeanDefinition)

                OtherService otherService = (OtherService) secondContext.getBean("otherService");
                String msg = otherService.getMessage();
                System.out.println(msg);

//              When main method is ending, container (context) is steel working (not destroy). To destroy container we need handle and aware call method destroy from AbstractApplicationContext - see below:
//              Additional - bean can't scope on "prototype".
                AbstractApplicationContext apc = (AbstractApplicationContext) secondContext;
                apc.destroy();

//              Second approach to call initialize and destroy method is an implements interface InitializingBean and DisposableBean
        }

}

