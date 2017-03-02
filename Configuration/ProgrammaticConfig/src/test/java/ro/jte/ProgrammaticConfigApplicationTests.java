package ro.jte;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import ro.jte.beans.ReloadableBean;

import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgrammaticConfigApplicationTests {

    static Logger log = Logger.getLogger(ProgrammaticConfigApplicationTests.class.getName());

    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private ReloadableBean reloadableBean;

    @Autowired
    private ContextRefresher refresher;



    @Test
    public void contextLoads() {
        log.info("StrProp = " + reloadableBean.getStrProp());
        EnvironmentTestUtils.addEnvironment(environment, "app.strProp:Hello test");
        log.info("StrProp = " + reloadableBean.getStrProp());
        refresher.refresh();
        log.info("StrProp = " + reloadableBean.getStrProp());
    }


}
