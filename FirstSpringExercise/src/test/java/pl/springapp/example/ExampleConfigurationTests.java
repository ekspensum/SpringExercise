package pl.springapp.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.springapp.tasks.SomeService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleConfigurationTests {

        @Autowired
        private SomeService service;

        @Test
        public void testSimpleProperties() throws Exception {
                assertNotNull(service);
        }

}

