package ro.jte.config.properties;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Min;
import java.util.List;

@Configuration
@ConfigurationProperties("app")
@RefreshScope
@Data
public class AppDevProperties {
    /*
     * relaxed binding
     *
     *	person.firstName Standard camel case syntax.
     *	person.first-name  Dashed notation, recommended for use in .properties and .yml files.
     *	person.first_name Underscore notation, alternative format for use in .properties and .yml files.
     *	PERSON_FIRST_NAME Upper case format. Recommended when using a system environment variables.
     *
     */

    private String strProp;

    List<MenuItem> menus;

    @Data
    public static class MenuItem {

	private Integer id;
	@NotBlank
	private String name;
	@Min(0)
	private Float price;
    }

}
