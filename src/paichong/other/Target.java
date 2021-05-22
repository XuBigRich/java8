package paichong.other;


import java.util.List;

/**
 * @author 许鸿志
 * @since 2021/5/19
 */
public class Target {
    public String name;
    public List<String> tag;
    public int sort;

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
