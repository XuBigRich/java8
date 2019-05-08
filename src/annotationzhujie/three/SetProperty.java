package annotationzhujie.three;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SetProperty.java
 * @Description TODO
 * @createTime 2019年01月28日 15:10:00
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetProperty {
    String name();
    int leng();
}
