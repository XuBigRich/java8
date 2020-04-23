package Class.fanshe.getInteface;

public class LiuDeHuaStar implements Star,Person {
    @Override
    public String sing(String name) {
        System.out.println("给我一杯忘情水");

        return "唱完";
    }

    @Override
    public String dance(String name) {
        System.out.println("开心的马骝");

        return "跳完";
    }

    @Override
    public void say() {

    }
}
