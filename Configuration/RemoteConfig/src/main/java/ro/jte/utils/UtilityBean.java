package ro.jte.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import ro.jte.hazelcast.HazelcastCluster;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Alex on 3/14/2017.
 */
@Component
@RefreshScope
public class UtilityBean {

    @Value( "${string}" )
    private String stringProperty;

    @Value( "${integer}" )
    private Integer longProperty;

    @Value( "${boolean}" )
    private Boolean booleanProperty;

    @Override
    public String toString() {
        return "UtilityBean{" +
                "stringProperty='" + stringProperty + '\'' +
                ", integerProperty=" + longProperty +
                ", booleanProperty=" + booleanProperty +
                '}';
    }
}
