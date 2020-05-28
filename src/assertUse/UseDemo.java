package assertUse;

/**
 * 如果启用断言 需要在 启动类的时候加入-ea 这个参数 断言才会起作用  有点类似于 安全管理器
 * 不添加-ea这个参数 断言将不会执行
 * 另外
 *  断言只是为了用来调试程序，切勿将断言写入业务逻辑中。比如考虑下面这个简单的例子
 */
public class UseDemo {
    public static void main(String[] args) {
        try{
            assert 1>2;
        }catch (AssertionError e){
            //抛出这个异常
            e.printStackTrace();
        }
        assert 1<2:"我是你永远的不到的输出";
        assert 1>2:"什么乱七八糟";
    }
}
