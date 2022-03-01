package ma.octo.context.config;

import ma.octo.context.services.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
public class ServiceConfig {

  @Primary
  @Lazy
  @Bean(value = {"greetingService", "greeting"}, initMethod = "init", destroyMethod = "destroy")
  public GreetingService greetingService() {
    return new GreetingService();
  }
}
