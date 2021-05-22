package hashcode;

import java.util.Objects;

/**
 * @author 许鸿志
 * @since 2021/5/22
 */

public class RewriteHashCode {
    private String name;
    private String sex;
    private Integer age;

    public RewriteHashCode(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewriteHashCode that = (RewriteHashCode) o;
        return Objects.equals(name, that.name) && Objects.equals(sex, that.sex) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }

    public static void main(String[] args) {
        RewriteHashCode p1 = new RewriteHashCode("许鸿志", "男", 24);
        RewriteHashCode p2 = new RewriteHashCode("许鸿志", "男", 24);
        System.out.println(p2.hashCode()+" "+p1.hashCode());

    }
}
