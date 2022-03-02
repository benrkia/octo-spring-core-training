package ma.octo.aop;

import ma.octo.aop.config.AppConfig;
import ma.octo.aop.service.LanguageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CLI {
  public static void main(String[] args) {
    final var context = new AnnotationConfigApplicationContext(AppConfig.class);

    final var languageService = context.getBean(LanguageService.class);

  }

}
