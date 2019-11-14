package rongqi.SetDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.LinkedHashSet;  
/**
 * hashSet不保证 元素的 添加的自然顺序
 * @author hongzhi.xu
 * @version 创建时间：2019年10月16日 下午1:55:41
 */
public class SetDemo {
	public static void testHashSet() {
		Set<String> set=new HashSet();
		set.add("111");
		set.add("222");
		set.add("333");
		set.add("444");
		set.add("555");
		set.add("666");
		set.add("777");
		set.add("888");
		set.add("999");
		set.add("101010");
		set.add("111111");
		for(String aaa:set) {
			System.out.println(aaa);
		}
	}
	public static void testLinkedHashset() {
		Set<String> set=new LinkedHashSet<String> ();
		set.add("111");
		set.add("222");
		set.add("333");
		set.add("444");
		set.add("555");
		set.add("666");
		set.add("777");
		set.add("888");
		set.add("999");
		set.add("101010");
		set.add("111111");
		for(String aaa:set) {
			System.out.println(aaa);
		}
	}
	public static void main(String[] args) {
//		testHashSet();
		testLinkedHashset();
	}
}
