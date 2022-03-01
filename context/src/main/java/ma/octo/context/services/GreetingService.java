package ma.octo.context.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Lazy
@Primary
@Component("greetingService")
public class GreetingService implements InitializingBean, DisposableBean {
  private static final String GREETING_PLACEHOLDER = "Hello %s!\n";

  static {
    System.out.println("--GreetingService is loaded into memory");
  }

  public GreetingService() {
    System.out.println("--Constructor called");
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("--PostConstruct called");
  }

  @Override
  public void afterPropertiesSet() {
    System.out.println("--Init called");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("--PreDestroy called");
  }

  @Override
  public void destroy() {
    System.out.println("--Destroy called");
  }

  public void greet(final String name) {
    System.out.printf(GREETING_PLACEHOLDER, name);
  }

}
