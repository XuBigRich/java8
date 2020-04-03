package leixingzhuanhuan.duixiangleixingzhuanhuan;

public class Xiangshangzhuanxing {
	public String getName(Boy boy) {
		Man xhz=(Man)boy;
		return xhz.getName();
	}
	public static void main(String[] args) {
		Xxx aa=new Xxx();
		Man man=new Man();
		man.name="xff";
//		aa.name="xff";
		Xiangshangzhuanxing x=new Xiangshangzhuanxing(); 
//		System.out.println(x.getName(aa));
		System.out.println(x.getName(man));
		
		Girl girl = new Girl();
		girl.name = "fmj";
		Woman fmj = (Woman) girl;
		fmj.getName();
		System.out.println(fmj);
		
		
	}
}

class Girl {
	String name;
	String sex = "";
}

class Woman extends Girl {
	String name;

	public String getName() {
		return this.name;
	}
}
//===========================
interface Boy {
	public void getSex();
}

class Man implements Boy{
	String name;
	public String getName() {
		return this.name;
	}
	public void getSex() {};
}

class Xxx implements Boy{
	String name;
	public void getSex() {};
}