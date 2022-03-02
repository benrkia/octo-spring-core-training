package ma.octo.environment.abstraction.util;

public interface Logger {
  void info(String content);
  void debug(String content);
  void error(String content);
}
