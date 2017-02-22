package ro.jte;

import io.atomix.catalyst.transport.Address;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ro.jte.atomix.AtomixConfig;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RemoteConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoteConfigApplication.class, args);
    }

    @Bean
    public AtomixConfig atomixConfigBean() {
        List<Address> cluster = Arrays.asList(
                new Address("localhost", 8700)
        );

        return new AtomixConfig(cluster);
    }
}
