package Static;

public  class Statc {

    public static int v=1;

    private static  String a= bbb();
    //���bbb���Ǿ�̬(static)����  ��ô ������� ��������Ϊ aΪ��̬��������̬������ʼ��ֵһ��Ҫ�Ǿ�̬���� ���������
    public static String bbb(){
        System.out.println("bbb��ִ��");
        return  "aaa";
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    //In
    static int iwrap=new Integer(v);
    public static void main(String[] args) {
        Statc e=new Statc();
        e.setA("a");
        //�ȳ�ʼ�� �ٱ���ֵ
        System.out.println(e.getA());
        //int���Ա�Integer��װ��Ҳ���Ա�int����
        System.out.println(iwrap);
    	}

}
