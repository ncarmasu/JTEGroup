package ro.jte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.jte.Property;
import ro.jte.atomix.AtomixConfig;

import javax.annotation.Resource;
import java.util.Set;

@RestController
public class AtomixController {

    @Resource(name = "atomixConfigBean")
    AtomixConfig atomixConfig;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/properties")
    public Set<String> propertyKeys() {
        return atomixConfig.getKeys();
    }

    @RequestMapping("/property")
    public String getProperty(@RequestParam("key") String key) {
        return atomixConfig.getPropertyFromCluster(key).toString();
    }

    @RequestMapping(value="/property", method = RequestMethod.POST)
    public void addProperty(@RequestBody Property property) {
        atomixConfig.addPropertyToCluster(property.getKey(), property.getValue());
    }
}
