package String;

public class Split {
	public static String[] splitDemo(String targer, String split) {
		return targer.split(split);
	}

	public static void main(String[] args) {
		String targer1="aaa";
		String targer2="aaa,bbb";
		String targer3="aaa,";
		System.out.println(splitDemo(targer1,",")[0]);
		System.out.println(splitDemo(targer2,",")[0]);
		System.out.println(splitDemo(targer3,",")[0]);
	}
}
