package ro.jte.atomix;

import io.atomix.AtomixClient;
import io.atomix.catalyst.transport.Address;
import io.atomix.catalyst.transport.netty.NettyTransport;
import io.atomix.collections.DistributedMap;
import io.atomix.variables.DistributedValue;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class AtomixConfig {
    private AtomixClient client;
    private List<Address> cluster;

    public AtomixConfig(List<Address> cluster){
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

    public Object getPropertyFromCluster(String key) {
        Object result = null;
        try {
            result = client.<Object>getValue(key).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return result;
    }

    private void connect(List<Address> cluster) {
        client = AtomixClient.builder()
                .withTransport(new NettyTransport())
                .build();

        client.connect(cluster).join();
    }
}
