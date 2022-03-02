package ma.octo.environment.abstraction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "ma.octo",
    excludeFilters = @Filter(type = FilterType.REGEX, pattern = "ma.octo.environment.abstraction.entity.*"))
@PropertySource("classpath:application.properties")
public class AppConfig {
}
