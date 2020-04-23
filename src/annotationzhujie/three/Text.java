package annotationzhujie.three;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Text.java
 * @Description TODO
 * @createTime 2019年01月28日 15:16:00
 */
public class Text {
    //获取类的 类类型
 public static Class get(){
     UserEntity user=new UserEntity();
     Class c= user.getClass();
    return c;
 }
 //获取类上的 注解
 public static void  annotclass(Class n){
    //1.项目上用到了哪些注解
     Annotation[] annotations=n.getAnnotations();
     for(Annotation annotation: annotations){
         System.out.println(annotation);
     }
     //getAnnotations 获取某个注解对象
     SetTable setTable=(SetTable)n.getAnnotation(SetTable.class);
     System.out.println(setTable);
     System.out.println(setTable.value());
 }
 //获取属性上的注解
    public static void annotfields(Class n){
        Field[] fields= n.getDeclaredFields();
        for(Field field:fields){
            try{
                SetProperty setProperty=field.getAnnotation(SetProperty.class);
                System.out.println(setProperty.name());
            }catch (java.lang.NullPointerException e){

            }
        }
    }
 //使用反射 搭配 注解 构造 sql语句
    public static String tableName;
    public static StringBuffer propertyName =new StringBuffer();
public static String append(Class n){
   String sql ="select ? from %";
        StringBuffer sqll=new StringBuffer("select ");
   SetTable setTable=(SetTable)n.getAnnotation(SetTable.class);
   tableName=setTable.value();
    Field[] fields= n.getDeclaredFields();
   for(int i=0;i<n.getDeclaredFields().length;i++){
     Field field=  fields[i];
       try{
           SetProperty setProperty=field.getAnnotation(SetProperty.class);
           System.out.println(setProperty.name());
           if(i==n.getDeclaredFields().length-1){
               propertyName.append(setProperty.name());
           }else {
               propertyName.append(setProperty.name()+",");
           }
       }catch (java.lang.NullPointerException e){

       }
    }
    System.out.println(propertyName);
    System.out.println(tableName);

   String sql1= sql.replace("?",propertyName);
    String sql2=sql1.replace("%",tableName);
    //===========================================
    sqll.append(propertyName);
    sqll.append(" from ");
    sqll.append(tableName);
    System.out.println("sqll:"+sqll);
return sql2;
}

 public static void main(String[] args) {
       Class a= Text.get();
         annotfields(a);
         annotfields(a);
     System.out.println(append(a));

 	}
}
