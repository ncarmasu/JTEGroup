package ro.jte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.jte.hazelcast.HazelcastCluster;
import ro.jte.utils.UtilityBean;

@SpringBootApplication
public class RemoteConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoteConfigApplication.class, args);
    }

    @Bean
    public HazelcastCluster hazelcastClusterBean() {
        return new HazelcastCluster();
    }

    @Bean
    public UtilityBean utilityBean() {
        return new UtilityBean();
    }
}
