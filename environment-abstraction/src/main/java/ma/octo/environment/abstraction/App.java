package ma.octo.environment.abstraction;

import ma.octo.environment.abstraction.config.AppConfig;
import ma.octo.environment.abstraction.service.LanguageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {
    final var context = new AnnotationConfigApplicationContext(AppConfig.class);

    final var languageService = context.getBean(LanguageService.class);

    languageService.findAllLanguages()
        .forEach(System.out::println);

  }

}
