package anomaly;
/**
 * 异常解决 办法
 * @author hongzhi.xu
 * @version 创建时间：2019年11月10日 上午11:51:48
 */
public class ErrorTest {
	public void trytest() {
		try {
		int a=1/0;
		}catch (java.lang.ArithmeticException e) {
			System.out.println("我继续运行了");
		}
	}
	public void throwtest() throws java.lang.ArithmeticException {
		int a=1/0;
		System.out.println("我继续运行了");
	}
	public void trywhile() {
		try {
			while(true) {
				int a=1/0;
			}
			}catch (java.lang.ArithmeticException e) {
				System.out.println("我持续继续运行了");
			}
	}
	public static void main(String[] args) {
		ErrorTest aErrorTest=new ErrorTest();
//		aErrorTest.trytest();
//		aErrorTest.throwtest();
		aErrorTest.trywhile();
	}
}
