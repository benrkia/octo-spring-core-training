package ma.octo.context;

import ma.octo.context.services.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    final var context = new ClassPathXmlApplicationContext("services.xml");

    final var greetingService = context.getBean("greetingService", GreetingService.class);

    greetingService.greet("Octo");

  }

}
