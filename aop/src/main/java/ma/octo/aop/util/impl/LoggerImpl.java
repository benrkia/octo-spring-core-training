package ma.octo.aop.util.impl;

import ma.octo.aop.util.Logger;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class LoggerImpl implements Logger {

  private final Class<?> clazz;
  private final Environment environment;

  public LoggerImpl(final Class<?> clazz, final Environment environment) {
    this.clazz = clazz;
    this.environment = environment;
  }

  @Override
  public void info(final String content) {
    if (cantLog(Level.INFO)) return;
    System.out.println(formatMessage(Level.INFO, content));
  }

  @Override
  public void debug(final String content) {
    if (cantLog(Level.DEBUG)) return;
    System.out.println(formatMessage(Level.DEBUG, content));
  }

  @Override
  public void error(final String content) {
    if (cantLog(Level.ERROR)) return;
    System.out.println(formatMessage(Level.ERROR, content));
  }

  private boolean cantLog(final Level requiredLevel) {
    final Level currentLevel = getLogLevel();
    return Level.compare(currentLevel, requiredLevel) > 0;
  }

  private Level getLogLevel() {
    final var logLevel = environment.getProperty("LOG_LEVEL");
    return Level.fromKeyOrDefault(logLevel);
  }

  private String formatMessage(final Level level, final String message) {
    final var now = LocalDateTime.now().toString();
    final var threadName = Thread.currentThread().getName();
    return String.format("%s [%s] %s (%s) - %s", now, threadName, level.key, clazz.getSimpleName(), message);
  }

  private enum Level {
    ALL("ALL", 0),
    DEBUG("DEBUG", 0),
    INFO("INFO", 1),
    ERROR("ERROR", 2);

    private final String key;
    private final int priority;

    Level(String key, int priority) {
      this.key = key;
      this.priority = priority;
    }

    static Level fromKeyOrDefault(final String key) {
      return Arrays.stream(values()).filter(level -> level.key.equalsIgnoreCase(key))
          .findAny()
          .orElse(INFO);
    }

    static int compare(final Level l1, final Level l2) {
      Objects.requireNonNull(l1);
      Objects.requireNonNull(l2);

      return l1.priority - l2.priority;
    }
  }
}
