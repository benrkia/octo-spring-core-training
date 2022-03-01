package ma.octo.context.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("thread")
public class TopicRepository {

  public String getCurrentTopic() {
    return "Spring";
  }
}
