package ro.jte;

import io.atomix.catalyst.transport.Address;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.jte.atomix.AtomixCluster;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RemoteConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoteConfigApplication.class, args);
    }

    @Bean
    public AtomixCluster atomixClusterBean() {
        List<Address> cluster = Arrays.asList(
                new Address("localhost", 8700)
        );

        return new AtomixCluster(cluster);
    }
}
