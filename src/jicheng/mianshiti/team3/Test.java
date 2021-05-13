package jicheng.mianshiti.team3;

/**
 * @Author： hongzhi.xu
 * @Date: 2020/12/31 下午2:52
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        AA aa = new BB();
        aa.f();
        aa.g();
        Test test = new Test();
        test.test();
        test.test2();
    }

    public void test() {
        int isSix = 0, sum = 0, avg = 0;
        int[] nums = new int[100];
        for (int i = 0; i <= 99; i++) {
            int num = (int) ((Math.random() * 6) + 1);
            nums[i] = num;
            if (num == 6) {
                isSix++;
            }
            sum += num;
        }
        avg = sum / 100;
        System.out.println(isSix + " " + sum + " " + avg);
    }

    public void test2() {
        int i, j;
        for (i = 0; i < 5; i++) {//控制行数
            for (j = 0; j <= i; j++) {//控制*的数量
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
