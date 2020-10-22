package classDemo.neibuClass.use;



/**
 * 你不能在 if 之外创建这个内部类的对象，因为这已经超出了它的作用域。
 * 不过在编译的时候，内部类 TrackingSlip 和其他类一样同时被编译，只不过它由它自己的作用域，超出了这个范围就无效，
 * 除此之外它和其他内部类并没有区别。
 *
 * @Author： hongzhi.xu
 * @Date: 2020/10/21 10:59 上午
 * @Version 1.0
 */
public class Goods4 {

    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;


                TrackingSlip(String s) {
                    id = s;
                }


                String getSlip() {
                    return id;
                }

            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Goods4 g = new Goods4();
        g.track();
    }
}
