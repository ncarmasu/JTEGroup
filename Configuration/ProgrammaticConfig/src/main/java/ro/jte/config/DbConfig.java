package ro.jte.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Narcis on 2/20/2017.
 */
@Getter
@Setter
public class DbConfig {

    @Value("jdbc.url")
    private String url;
    @Value("jdbc.username")
    private String username;
    @Value("jdbc.password")
    private String password;
    @Value("jdbc.driverClassName")
    private String driverClassName;
}
