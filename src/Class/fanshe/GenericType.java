package Class.fanshe;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取类的泛型
 *
 * @author 许鸿志
 * @since 2022/6/13
 */

interface GenericTypeInterface<S> {

}

public class GenericType<G, Integer> implements GenericTypeInterface<Integer> {
    /**
     * 获取类上面的，大量应用与mybatis-plus上面 获取泛型类中的泛型参数数组。
     *
     * @param c
     * @param <T>
     * @return
     */
    public static <T> TypeVariable<Class<T>>[] getTypeVariables(Class c) {
        TypeVariable<Class<T>>[] result = c.getTypeParameters();
        return result;
    }

    public static void printTypeVariableClass(TypeVariable<Class<?>>[] typeVariables) {
        List<Class> classes = Arrays.stream(typeVariables).map(TypeVariable::getGenericDeclaration).collect(Collectors.toList());
        classes.forEach(System.out::println);
    }

    /**
     * 打印输出类上面的泛型
     */
    public static void print(Type[] typeVariable) {
        List r = Arrays.stream(typeVariable).map(Type::getTypeName).collect(Collectors.toList());
        r.forEach(System.out::println);

    }

    /**
     * 获取类上面的，大量应用与mybatis-plus上面 获取当前Class对象实现的接口数组，但是后者会带上接口的泛型参数，如  getInterfaces,getGenericInterfaces
     *
     * @param c
     * @return
     */
    public static Type[] getGenericType(Class c) {
        Type[] result = c.getGenericInterfaces();
        return result;
    }

    public static void main(String[] args) {
        GenericType<String, Class> target = new GenericType();
        TypeVariable[] typeVariable = getTypeVariables(target.getClass());
        print(typeVariable);
        printTypeVariableClass(typeVariable);
        Type[] types = getGenericType(target.getClass());
        print(types);
    }
}
