package annotationzhujie.two;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义注解 ： 使用@interfacet
 * @Targe :定义 注解使用范围
 * @Retention :表示允许反射获取信息
 */
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDemo {
    String value();
    int classId() default 10;
    String[] arrAr();
}

class AnnDemo{
    private String name;
    @AnnotationDemo(value = "aa",arrAr = {"111","2222"})
    public void add(){

    }
}