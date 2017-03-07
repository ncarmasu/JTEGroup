package ro.jte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.jte.hazelcast.HazelcastCluster;

@SpringBootApplication
public class RemoteConfigApplication {

    public static void main(String[] args) {

        SpringApplication.run(RemoteConfigApplication.class, args);
    }

    @Bean
    public HazelcastCluster hazelcastClusterBean() {
        return new HazelcastCluster();
    }
}
