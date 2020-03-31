package io.stream.xuliehua.standard;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 序列化  
 * 关于序列号 id
 * 1. 所有实现序列化的类，　都推荐显式声明序列化ID
	2. 序列化ID的访问类型 推荐为 private, 因为只在自己内部被使用, 不会因为继承而流到子类
	3. 数组是无法显示声明序列化ID的(比如String[], 你无法在其中声明serialVersionUID), 但是java的序列化也不会对数组对象进行serialVersionUID 的比较
 * @author hongzhi.xu
 * @version 创建时间：2019年11月14日 上午10:41:01
 */
public class Girl implements Serializable {
	//女孩的年龄是秘密 所以 要设置为 私有的
	private int old;
	public int height;

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	public static void main(String[] args) {
		Girl myGirl = new Girl();
		myGirl.setOld(22);
		myGirl.setHeight(176);

		try {
			FileOutputStream fs = new FileOutputStream("Girl.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(myGirl);
			os.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
