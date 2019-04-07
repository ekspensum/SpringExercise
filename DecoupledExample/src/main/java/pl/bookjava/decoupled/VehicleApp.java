package pl.bookjava.decoupled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VehicleApp {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
//              VehicleService service = new VehicleService();
//              service.driver();

//              new ClassPathXmlApplicationContext("beans.xml").getBean("vehicleService", VehicleService.class).driver();

                ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
                context.getBean("vehicleService", VehicleService.class).driver();
        }

}

