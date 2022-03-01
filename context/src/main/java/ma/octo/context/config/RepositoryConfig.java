package ma.octo.context.config;

import ma.octo.context.repositories.TopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoryConfig {

  @Bean
  @Scope("thread")
  public TopicRepository topicRepository() {
    return new TopicRepository();
  }
}
