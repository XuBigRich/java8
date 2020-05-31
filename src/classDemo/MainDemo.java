package classDemo;

public class MainDemo {
    public static void main(String[] args) {
        StringBuffer buffer=new StringBuffer("FileDescriptorUse.hello world!");
        System.out.println(args.length);
        for(String name:args){
            System.out.println(name);
        }
    }
}
