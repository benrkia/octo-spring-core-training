package ma.octo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

  @Pointcut("execution(public * ma.octo.aop.service.LanguageService.getLanguageBy*(..))")
  private void languageServiceFindBy(){}

  @Around("languageServiceFindBy()")
  public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    final var start = System.currentTimeMillis();
    final var methodName = joinPoint.getSignature().getName();

    final var object = joinPoint.proceed();

    logExecutionTime(methodName, start);

    return object;
  }

  private void logExecutionTime(final String methodName, final long start) {
    final var execTime = (System.currentTimeMillis() - start) / 1000;
    System.out.printf("%s took: %ds\n", methodName, execTime);
  }
}
