package paichong.self;


import java.util.List;

/**
 * @author 许鸿志
 * @since 2021/5/19
 */
public class Target {
    public String name;
    public List<String> tag;
    public int sort;

    /**
     * 重写equals 关键
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        Target myList = (Target) o;
        return  myList.tag.toString().equals(tag.toString());
    }

    /**
     * 重写hashCode 关键
     * @return
     */
    public int hashCode() {
        return tag.hashCode();
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Target{" +
                "name='" + name + '\'' +
                ", tag=" + tag +
                '}';
    }

}
