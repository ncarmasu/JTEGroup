package ro.jte;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ro.jte.properties.HierarchicalProperties;

import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticConfigApplicationTests {

    static Logger log = Logger.getLogger(StaticConfigApplicationTests.class.getName());

    @Autowired
    private HierarchicalProperties hierarchicalProperties;

    @Test
    public void contextLoads() {
        log.info("StrProp = " + hierarchicalProperties.toString());
    }

}
