package ro.jte.controller;

import org.springframework.web.bind.annotation.*;
import ro.jte.Property;
import ro.jte.atomix.AtomixCluster;

import javax.annotation.Resource;
import java.util.Set;

@RestController
public class AtomixController {

    @Resource(name = "atomixClusterBean")
    AtomixCluster atomixCluster;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/properties")
    public Set<String> propertyKeys() {
        return atomixCluster.getKeys();
    }

    @RequestMapping("/add")
    public void addString() {
        atomixCluster.addStringPropertyToCluster("test", "value");
    }

    @RequestMapping("/property")
    public String getProperty(@RequestParam("key") String key) {
        return atomixCluster.getPropertyFromCluster(key).toString();
    }

    @RequestMapping(value="/property", method = RequestMethod.POST)
    public void addProperty(@RequestBody Property property) {
        atomixCluster.addPropertyToCluster(property.getKey(), property.getValue());
    }
}
