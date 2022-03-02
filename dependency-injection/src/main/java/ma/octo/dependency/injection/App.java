package ma.octo.dependency.injection;

import ma.octo.dependency.injection.config.AppConfig;
import ma.octo.dependency.injection.service.LanguageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {
    final var context = new AnnotationConfigApplicationContext(AppConfig.class);

    final var languageService = context.getBean(LanguageService.class);

    languageService.findAllLanguages()
        .forEach(System.out::println);

  }

}
