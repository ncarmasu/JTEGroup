package ro.jte.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.jte.config.DevAppConfig;

import java.util.Arrays;

/**
 * Created by Narcis on 2/9/2017.
 */

@RestController
@RequestMapping("/listProps")
public class ListPropertiesController {

//    @Autowired
//    private ConfigurableApplicationContext appContext;

    @Autowired
    private DevAppConfig config;
//    @Autowired
//    private ProdAppConfig config;

    @Autowired
    private Environment env;

    @RequestMapping(method = RequestMethod.GET)
    public String listProps() {
        StringBuilder sb = new StringBuilder();

        sb.append("ACTIVE PROFILES: ").append(Arrays.toString(env.getActiveProfiles())).append("</br>");
        sb.append("DEFAULT PROFILES: ").append(Arrays.toString(env.getDefaultProfiles())).append("</br>");

        sb.append(env.getProperty("simpleProperty")).append("</br>");
        sb.append(env.getProperty("overrideDefault")).append("</br>");
        sb.append(env.getProperty("toBeOverridden")).append("</br>");
        sb.append(env.getProperty("listOfValues")).append("</br>");


        sb.append(env.getProperty("jdbc.url")).append("</br>");
        sb.append(env.getProperty("jdbc.username")).append("</br>");
        sb.append(env.getProperty("jdbc.password")).append("</br>");
        sb.append(env.getProperty("jdbc.driverClassName")).append("</br>");

        printProps();
        return sb.toString();
    }

    private void printProps() {

        System.out.println("config.getSimpleProperty() = " + config.getSimpleProperty());
        System.out.println("config.getOverridenDefaultValue() = " + config.getOverridenDefaultValue());
        System.out.println("config.getPropWithDefaultValue() = " + config.getPropWithDefaultValue());
        System.out.println("config.getListOfValues() = " + config.getListOfValues());
    }
}
