package ro.jte.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by BunnyChu on 2/28/2017.
 */

@Component
public class SomeService {

    @Value("${someProperty}")
    private String someValue;

    public String getSomeValue() {
        return someValue;
    }
}
