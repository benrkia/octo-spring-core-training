package ma.octo.context;

import ma.octo.context.repositories.TopicRepository;
import ma.octo.context.services.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    final var context = new ClassPathXmlApplicationContext("context.xml");

    final var greetingService = context.getBean("greetingService", GreetingService.class);
    final var topicRepository = context.getBean("topicRepository", TopicRepository.class);

    greetingService.greet("Octo");
    System.out.println(topicRepository.getCurrentTopic());

  }

}
