package pl.bookjava.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                @SuppressWarnings("resource")
				ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
                context.getBean("bookServiceImpl", BookService.class).getAllBooks();
        }
}
