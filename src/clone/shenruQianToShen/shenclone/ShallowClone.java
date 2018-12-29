package clone.shenruQianToShen.shenclone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* 将拷贝 转换为深层拷贝的经典案例
* */
public class ShallowClone implements Cloneable {
    private String name;
    private int age;
    private List<String> books;


    public ShallowClone deepClone() {
        ShallowClone clone = new ShallowClone();
        clone.name = this.name;
        clone.age = this.age;
        if (this.books != null) {// 如果books里面有数据
            clone.books = new ArrayList<>(this.books); //那么复制的时候 新建立一个对象
        }
        return clone;
    }


    public static void main(String[] args) {
        ShallowClone shallowClone = new ShallowClone();
        shallowClone.setName("SourceName");
        shallowClone.setAge(28);
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c++");
        shallowClone.setBooks(list);
        ShallowClone cloneObj = shallowClone.deepClone();
        // 判断两个对象是否为同一个对象（即是否是新创建了一个实例）
        System.out.println(shallowClone == cloneObj);
        // 修改一个对象的内容是否会影响另一个对象
        shallowClone.setName("newName");
        shallowClone.setAge(20);
        shallowClone.getBooks().add("javascript");
        System.out.println("source: " + shallowClone.toString() + "\nclone:" + cloneObj.toString());
        shallowClone.setBooks(Arrays.asList("hello"));
        System.out.println("source: " + shallowClone.toString() + "\nclone:" + cloneObj.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "ShallowClone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }
}