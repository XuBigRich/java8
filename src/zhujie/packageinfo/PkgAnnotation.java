package zhujie.packageinfo;

import java.lang.annotation.Target;
import java.lang.annotation.*;
@Target(ElementType.PACKAGE)//包声明
@Retention(RetentionPolicy.RUNTIME) //RetentionPolicy.RUNTIME VM-------将在运行期也保留注释，因此可以通过反射机制读取注解的信息。 
public @interface PkgAnnotation {
}