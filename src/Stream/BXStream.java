package Stream;
/**
 * 并行流
 * @author hongzhi.xu
 * @version 创建时间：2019年10月14日 上午10:57:15
 */

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class BXStream {
	/**
	 * 顺序流
	 */
	public void test() {
		Instant start=Instant.now();
		LongStream.rangeClosed(0, 100000000L).reduce(0,Long::sum);
		Instant end=Instant.now();
		System.out.println("耗费时常为"+Duration.between(start, end).toMillis());
	}
	/**
	 * 并行流
	 */
	public void test1() {
		Instant start=Instant.now();
		LongStream.rangeClosed(0, 100000000L)
		 		  .parallel()
				  .reduce(0,Long::sum);
		Instant end=Instant.now();
		System.out.println("耗费时常为"+Duration.between(start, end).toMillis());
	}
	public static void main(String[] args) {
		BXStream bx=new BXStream();
		bx.test();
		bx.test1();
	}
	
}
