package annotationzhujie.two;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
* ②创建TestMethod注解，声明作用于方法并保留到运行时。
* */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestMethod {
    String value();
}
