package ro.jte.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

/**
 * Created by Narcis on 2/20/2017.
 */

@Configuration
@Profile({"prod"})
public class ProdAppConfig extends BaseConfig {

    @Value("simpleProperty")
    private String simpleProperty;

    @Value("${defaultValue:'DEFAULT_VALUE'}")
    private String propWithDefaultValue;

    @Value("${overrideDefault:'DEFAULT_VALUE'}")
    private String overridenDefaultValue;

    @Value("#{'${listOfValues}'.split(',')}")
    private List<String> listOfValues;
}
