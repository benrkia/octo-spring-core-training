package ma.octo.environment.abstraction.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(value = "ma.octo",
    excludeFilters = @Filter(type = FilterType.REGEX, pattern = "ma.octo.environment.abstraction.entity.*"))
@PropertySource("classpath:application.properties")
@Import({DevConfigProperties.class, ProdConfigProperties.class})
public class AppConfig {
}
