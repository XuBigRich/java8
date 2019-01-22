package Lambda.use;

public class TestLambda2 {
    public Long aaa (Long a,Long b,Count<Long,Long> count){
        return count.ccl(a,b);
    }
    public void bbb(long a,long b){
        System.out.println(aaa(a,b,(C,D)->C*D));
        System.out.println(aaa(a,b,(C,D)->C+D));
    }
public static void main(String[] args) {
    TestLambda2 testLambda2=new TestLambda2();
    testLambda2.bbb(5,6);
	}
}
