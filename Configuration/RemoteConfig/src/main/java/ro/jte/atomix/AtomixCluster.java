package ro.jte.atomix;

import io.atomix.AtomixClient;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.variables.DistributedValue;
import ro.jte.Property;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class AtomixCluster {
    private AtomixClient client;
    private List<Address> cluster;

    public AtomixCluster(List<Address> cluster){
        this.cluster = cluster;
        this.connect(this.cluster);
    }

    public Set<String> getKeys() {
        Set<String> keys = null;
        try {
            keys = this.client.keys().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return keys;
    }

    public void addPropertyToCluster(String key, Object value) {
        this.client.getValue(key).join().set(value);
    }

    public void addStringPropertyToCluster(String key, String value) {
        DistributedValue val = client.getValue(key).join();
        val.set(value, Duration.ofSeconds(1)).thenRun(() -> {
            System.out.println("Value set with TTL of 1 second");
        });
    }

    public Object getPropertyFromCluster(String key) {
        Object result = null;
        try {
            result = client.getValue(key).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return result;
    }

    public List<Property> getAllProperties() {
        Set<String> keys = getKeys();
        List<Property> properties = new ArrayList<>();

        for(String key : keys) {
            client.getValue(key).thenAccept(value -> {
                try {
                    properties.add(new Property(key, value.get().get()));
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }

        return properties;
    }

    private void connect(List<Address> cluster) {
        client = AtomixClient.builder()
                .withTransport(new NettyTransport())
                .build();

        client.connect(cluster).join();
    }
}
