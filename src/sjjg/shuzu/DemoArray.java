package sjjg.shuzu;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName DemoArray.java
 * @Description TODO
 * @createTime 2019年02月19日 13:16:00
 */
public class DemoArray {
    private long[] arry;
    private int element;
    public DemoArray(){
        arry=new long[50];
    }
    public DemoArray(int maxsize){
        arry=new long[maxsize];
    }
    /*
    * 添加数据
    * */
    public void insert(long value){
        arry[element]=value;
        element++;
    }
    /*
    * 显示数据
    * */
    public void display(){
        System.out.print("[");
        for (int i=0;i<element;i++){
            System.out.print(arry[i]);
            if(i<element-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    /*
    * 查找数据  （线性查找）
    * */
    public int search(long value){
        int i;
        for(i=0;i<element;i++){
            if(value==arry[i]){
                break;
            }
        }
        if(i==element){
            return -1;
        }else {
            return i;
        }
    }
    /*
    * 查找数据 （二分法查找） 必须是有序数组
    * */
    public int binarySearch(long value){
        int middle=0;//数组中间数
        int low=0;
        int pow=element-1;
        while(true){
            middle=(low+pow)/2;
            if(arry[middle]==value){
                return middle;
            }else if(pow<low){
                System.out.println("有问题");
                return -1;
            }else if (arry[middle]>value){
                pow=middle-1;
            }else if(arry[middle]<value){
                low=middle+1;
            }
        }
    }
    /*
     * 添加有序数组
     * */
    public void insertasc(long a){
        int i;
        for(i=0;i<element;i++){//遍历数组
            if(arry[i]>a){ //判断数组中是否存在大于a的元素
                break;   // 只要存在比a大的 就跳出当前循环记录i位置
            }
        }
        for(int j=element;j>i;j--) { //进入循环 j小于element 大于i最后记录的位置 j>i的意思就是把i位空出来
            arry[j] = arry[j - 1];    //将判断好的 位置集体后移
        }
        arry[i]=a;  //因为i位重复  所以 直接替换掉i位
        element++;
    }
    public long get(int index){
        if(index>=element||index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            return arry[index];
        }
    }
    public void delete(int index){
        if(index>=element||index<0){ 
            throw new ArrayIndexOutOfBoundsException();
        }else {
           for (int i=index;i<element;i++){
               arry[index]=arry[index+1];
           }
           element--;
        }
    }
    public void change(int index,long value){
        if(index>=element||index<0){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            arry[index]=value;
        }
    }

    public long[] getArry() {
        return arry;
    }

    public void setArry(long[] arry) {
        this.arry = arry;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }
}
