package pl.springapp.tasks;

import org.springframework.stereotype.Component;


/**
 * {@link SomeService} with hard-coded input data.
 */
@Component //not need if use JavaConfig or xml file configuration approach
public class ExampleService implements SomeService {

        /**
         * Reads next record from input
         */
        public String getMessage() {
                return "Hello world! - from ExampleService";
        }

}
