package ma.octo.environment.abstraction.config;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("prod")
@PropertySource("classpath:application-prod.properties")
public class ProdConfigProperties {
}
