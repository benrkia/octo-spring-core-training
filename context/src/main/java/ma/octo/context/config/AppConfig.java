package ma.octo.context.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class})
public class AppConfig {
}
