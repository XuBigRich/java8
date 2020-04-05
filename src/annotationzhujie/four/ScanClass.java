package annotationzhujie.four;

import annotationzhujie.three.SetTable;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ScanClass {
    @Transaction
    public  void test(){

    }
    public static String dir=System.getProperty("user.dir");
    public static String path=System.getProperty("java.class.path");
    public static Set<String> classFile=new HashSet();
    public void searchClass() throws ClassNotFoundException {
        System.out.println(path);
       String [] paths= path.split(";");
       for(String path:paths){
          if (path.contains(dir))
           System.out.println(path);

        String packageDir=dir+File.separator+"annotationzhujie"+File.separator+"four";
        File file=new File(packageDir);
        if(!file.exists()){
            continue;
        }
        File[] files=file.listFiles();
        for(File file1:files){
            if(file1.getName().contains(".class"))classFile.add(file1.getName().substring(0,file1.getName().length()-6));
        }
       }
       for(String name:classFile){
           Class classObject=Class.forName("annotationzhujie.four."+name);
           Method[] methods= classObject.getMethods();
           for(Method method:methods){
               try{
                   Transaction transaction= method.getAnnotation(Transaction.class);
                  String nameMethod= method.getName();
                   System.out.println(nameMethod);
               }catch (NullPointerException e){

               }
           }
       }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ScanClass scanClass=new ScanClass();
        scanClass.searchClass();
    }
}
