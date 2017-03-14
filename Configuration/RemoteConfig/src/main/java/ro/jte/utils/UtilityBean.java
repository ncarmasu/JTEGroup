package ro.jte.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ro.jte.hazelcast.HazelcastCluster;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Alex on 3/14/2017.
 */
@Component
public class UtilityBean {

    @Resource(name="hazelcastClusterBean")
    private HazelcastCluster cluster;

    private String stringProperty;

    private Integer longProperty;

    private Boolean booleanProperty;

    @PostConstruct
    public void init() {
        this.stringProperty = (String) cluster.getProperty("string.property");
        this.longProperty = (Integer) cluster.getProperty("integer.property");
        this.booleanProperty = (Boolean) cluster.getProperty("boolean.property");
    }

    @Override
    public String toString() {
        return "UtilityBean{" +
                "stringProperty='" + stringProperty + '\'' +
                ", integerProperty=" + longProperty +
                ", booleanProperty=" + booleanProperty +
                '}';
    }
}
