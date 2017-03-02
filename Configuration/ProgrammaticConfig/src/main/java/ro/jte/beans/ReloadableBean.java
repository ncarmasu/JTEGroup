package ro.jte.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import ro.jte.config.properties.AppDevProperties;

import java.util.List;


@RefreshScope
@Component
public class ReloadableBean {

    @Autowired
    private AppDevProperties props;

    public List<AppDevProperties.MenuItem> getMenuItemsList() {
        return props.getMenus();
    }

    public String getStrProp() {
        return props.getStrProp();
    }

}
