package Class.owned;

/**
 * 私有
 *
 * @Author： hongzhi.xu
 * @Date: 2023/1/13 5:26 下午
 * @Version 1.0
 */


public class Owned {
    private String a;
    private String b;

    private void ex(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public void exsss(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Owned{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
