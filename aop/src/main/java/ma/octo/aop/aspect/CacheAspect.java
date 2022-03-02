package ma.octo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.synchronizedMap;
import static java.util.stream.Collectors.toSet;

@Aspect
@Component
public class CacheAspect {
  private static final int CAPACITY = 2;
  private static final Map<Set<Object>, Object> CACHE;

  static {
    CACHE = synchronizedMap(new LinkedHashMap<>(CAPACITY + 1, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(final Map.Entry<Set<Object>, Object> eldest) {
        return CACHE.size() > CAPACITY;
      }
    });
  }

  @Pointcut("@annotation(ma.octo.aop.util.LRU)")
  private void lruAnnotated() {}

  @Around("lruAnnotated()")
  public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    final var key = constructJoinPointKey(joinPoint);

    if (CACHE.containsKey(key)) {
      return CACHE.get(key);
    }

    final var object = joinPoint.proceed();
    CACHE.put(key, object);

    return object;
  }

  private Set<Object> constructJoinPointKey(final JoinPoint joinPoint) {
    final var argsSet = Arrays.stream(joinPoint.getArgs()).collect(toSet());
    argsSet.add(joinPoint.getTarget());
    return Set.copyOf(argsSet);
  }
}
