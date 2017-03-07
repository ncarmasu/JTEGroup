package ro.jte.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

/**
 * Created by Alex on 3/7/2017.
 */
public class HazelcastCluster {

    private String PROPERTIES_MAP_KEY = "properties";
    private String LOCAL_CLUSTER = "127.0.0.1:5701";
    private HazelcastInstance instance;

    public HazelcastCluster(){
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress(LOCAL_CLUSTER);

        instance = HazelcastClient.newHazelcastClient(clientConfig);
    }

    public Map<String, Object> getProperties() {
        return instance.getMap(PROPERTIES_MAP_KEY);
    }

    public void addProperty(String key, Object value) {
        instance.getMap(PROPERTIES_MAP_KEY).put(key, value);
    }

    public Object getProperty(String key) {
        return instance.getMap(PROPERTIES_MAP_KEY).get(key);
    }
}
