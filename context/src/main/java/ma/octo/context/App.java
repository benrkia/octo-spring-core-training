package ma.octo.context;

import ma.octo.context.config.AppConfig;
import ma.octo.context.repositories.TopicRepository;
import ma.octo.context.services.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.SimpleThreadScope;

public class App {
  public static void main(String[] args) {
    final var context = new AnnotationConfigApplicationContext(AppConfig.class);
    context.getBeanFactory().registerScope("thread", new SimpleThreadScope());
    context.registerShutdownHook();

    final var greetingService = context.getBean("greetingService", GreetingService.class);
    final var topicRepository = context.getBean("topicRepository", TopicRepository.class);

    greetingService.greet("Octo");
    System.out.println(topicRepository.getCurrentTopic());

    assert greetingService == context.getBean("greeting", GreetingService.class);
    assert topicRepository == context.getBean("topicRepository", TopicRepository.class);

   new Thread(() -> {
     System.out.println(context.getBean("topicRepository", TopicRepository.class));
   }).start();

    new Thread(() -> {
      System.out.println(context.getBean("topicRepository", TopicRepository.class));
    }).start();

  }

}
