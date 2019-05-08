package shejimoshi.danlimoshi;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Danli.java
 * @Description TODO
 * @createTime 2019年04月11日 18:24:00
 */
public class Danli {
    static int i=1;
    private String name;
    public Danli(String name){
        this.name=name;
    }
    public static Danli A(String name){
        if(i==1) {
            i++;
            return new Danli(name);
        }else {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
