package ro.jte.controller;

import org.springframework.web.bind.annotation.*;
import ro.jte.utils.Property;
import ro.jte.hazelcast.HazelcastCluster;
import ro.jte.utils.UtilityBean;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Alex on 3/7/2017.
 */
@RestController
public class HazelcastController {

    @Resource(name = "hazelcastClusterBean")
    HazelcastCluster hazelcastCluster;

    @Resource(name = "utilityBean")
    UtilityBean utilityBean;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/properties")
    public Map<String,Object> getProperties() {
        return hazelcastCluster.getProperties();
    }

    @RequestMapping("/utility")
    public String getPropertiesFromUtilityBean() {
        return utilityBean.toString();
    }

    @RequestMapping("/property")
    public String getProperty(@RequestParam("key") String key) {
        return hazelcastCluster.getProperty(key).toString();
    }

    @RequestMapping(value="/property", method = RequestMethod.POST)
    public void addProperty(@RequestBody Property property) {
        hazelcastCluster.addProperty(property.getKey(), property.getValue());
    }
}
