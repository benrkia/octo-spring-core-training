package ma.octo.aop.config.annotation;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Profile({"default", "dev"})
@PropertySource("classpath:application-dev.properties")
public @interface Development {
}
