package ro.jte.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ro.jte.service.SomeService;

/**
 * Created by BunnyChu on 3/1/2017.
 */
 
@Configuration
@ComponentScan
@EnableScheduling
@EnableAutoConfiguration
public class SomeConfig {
    @Autowired
    private SomeService someService;

    @Scheduled(fixedRate = 10000)
    public void run() {
        System.out.println(someService.getSomeValue());
    }
}
