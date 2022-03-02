package ma.octo.aop;

import ma.octo.aop.config.AppConfig;
import ma.octo.aop.entity.Language;
import ma.octo.aop.service.LanguageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class CLI {
  private final LanguageService languageService;

  public CLI(final LanguageService languageService) {
    this.languageService = languageService;
  }

  public static void main(String[] args) {
    final var context = new AnnotationConfigApplicationContext(AppConfig.class);

    final var cli = new CLI(context.getBean(LanguageService.class));
    cli.start();

  }

  private void start() {
    final var sc = new Scanner(System.in);
    String cmd;

    while (true) {
      prompt();
      cmd = sc.nextLine();
      try {
        evaluate(cmd);
      } catch (IllegalStateException e) {
        System.out.println("Invalid command, try again");
      } catch (RuntimeException e) {
        break;
      }
    }
  }

  private void evaluate(final String cmd) {
    final var operation = cmd.split(" ")[0];
    switch (operation) {
      case "f": {
        findLanguageById(cmd.split(" ")[1]);
        break;
      }
      case "e": {
        findLanguageByExtension(cmd.split(" ")[1]);
        break;
      }
      case "q": throw new RuntimeException();
      default: throw new IllegalStateException();
    }
  }

  private void findLanguageByExtension(final String extension) {
    final var language = languageService.getLanguageByExtension(extension)
        .map(Language::toString)
        .orElse("Not Found");
    System.out.println(language);
  }

  private void findLanguageById(final String id) {
    final var language = languageService.getLanguageById(id)
        .map(Language::toString)
        .orElse("Not Found");
    System.out.println(language);
  }

  private void prompt() {
    System.out.println("Find language by id: f {id}");
    System.out.println("Find language by extension: e {extension}");
    System.out.println("Quit: q");
  }

}
