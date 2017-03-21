package ro.jte.properties;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Dragos on 19.03.2017.
 */
@Component
@ConfigurationProperties
@PropertySource("classpath:hierarchical-properties.yml")
public class HierarchicalProperties {

    @lombok.Getter
    @Setter
    private String var1;

    //used to check for type-casting
    @lombok.Getter
    @Setter
    private Integer var2;

//    @lombok.Getter
//    @Setter
    private List<String> var3;

    public HierarchicalProperties() {
    }

    //used to verify custom map binding
//    @lombok.Getter
//    @Setter
    private Map<String, Integer> somedata;

    public List<String> getVar3() {
        return var3;
    }

    public void setVar3(List<String> var3) {
        this.var3 = var3;
    }

    @Override
    public String toString() {
        return "HierarchicalProperties{" +
                "var1='" + var1 + '\'' +
                ", var2=" + var2 +
                ", var3=" + var3 +
                ", somedata=" + somedata +
                '}';
    }
}
