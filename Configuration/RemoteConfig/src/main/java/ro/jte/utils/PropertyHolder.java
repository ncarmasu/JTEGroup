package ro.jte.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;
import ro.jte.hazelcast.HazelcastCluster;

import java.util.Properties;

@Component
public class PropertyHolder extends PropertyPlaceholderConfigurer {

    Logger log = Logger.getLogger(PropertyPlaceholderConfigurer.class);
    HazelcastCluster hazelcastCluster = new HazelcastCluster();

    public PropertyHolder() {
        super();
    }


    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {

        Properties hazelcastProperties = new Properties();
        hazelcastProperties.putAll(hazelcastCluster.getProperties());

        super.processProperties(beanFactoryToProcess, hazelcastProperties);
    }

}
