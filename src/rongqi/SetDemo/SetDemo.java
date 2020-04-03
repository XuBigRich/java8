package rongqi.SetDemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
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
	public static void testSortedSet() {
		SortedSet<Integer> set=new TreeSet ();
		set.add(111);
		set.add(222);
		set.add(888);
		set.add(333);
		set.add(444);
		set.add(777);
		set.add(999);
		set.add(555);
		set.add(666);
		Iterator<Integer> iterator=set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("---------------------------");
		//返回某个元素前的所有元素
		SortedSet sortedSet=set.headSet(444);		
		Iterator<Integer> sorte=sortedSet.iterator();
		while(sorte.hasNext()) {
			System.out.println(sorte.next());
		}
		System.out.println("---------------------------");
		// 移除某个元素
		set.remove(555);
		Iterator<Integer> newSet=set.iterator();
		while(newSet.hasNext()) {
			System.out.println(newSet.next());
		}
		
	}
	public static void main(String[] args) {
//		testHashSet();
		//testLinkedHashset();
		testSortedSet();
		
	}
}
