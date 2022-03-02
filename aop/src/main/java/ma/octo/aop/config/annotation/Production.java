package ma.octo.aop.config.annotation;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Profile("prod")
@PropertySource("classpath:application-prod.properties")
public @interface Production {
}
