package ro.jte;

/**
 * Created by Alex on 3/7/2017.
 */
public class Property {

    String key;
    Object value;

    public Property() {

    }

    public Property(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
