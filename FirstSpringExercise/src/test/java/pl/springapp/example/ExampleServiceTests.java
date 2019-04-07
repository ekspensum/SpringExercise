package pl.springapp.example;

import junit.framework.TestCase;
import pl.springapp.tasks.ExampleService;

public class ExampleServiceTests extends TestCase {

        private ExampleService service = new ExampleService();

        public void testReadOnce() throws Exception {
                assertEquals("Hello world! - from ExampleService", service.getMessage());
        }

}

