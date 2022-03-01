package ma.octo.context.services;

public class GreetingService {
  private static final String GREETING_PLACEHOLDER = "Hello %s!\n";

  static {
    System.out.println("--GreetingService is loaded into memory");
  }

  public GreetingService() {
    System.out.println("--Constructor called");
  }

  public void init() {
    System.out.println("--Init called");
  }

  public void destroy() {
    System.out.println("--Destroy called");
  }

  public void greet(final String name) {
    System.out.printf(GREETING_PLACEHOLDER, name);
  }
}
