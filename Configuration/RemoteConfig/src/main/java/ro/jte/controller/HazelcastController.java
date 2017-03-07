package ro.jte.controller;

import org.springframework.web.bind.annotation.*;
import ro.jte.Property;
import ro.jte.hazelcast.HazelcastCluster;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 3/7/2017.
 */
@RestController
public class HazelcastController {

    @Resource(name = "hazelcastClusterBean")
    HazelcastCluster hazelcastCluster;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/properties")
    public Map<String,Object> getProperties() {
        return hazelcastCluster.getProperties();
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
