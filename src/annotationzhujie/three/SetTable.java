package annotationzhujie.three;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SetTable.java
 * @Description 表的别名
 * @createTime 2019年01月28日 14:57:00
 */
@Target(value = ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {
    String value();
}
