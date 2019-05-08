package sjjg.shuzu;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyArray.java
 * @Description TODO
 * @createTime 2019年02月18日 19:02:00
 */
public class MyArray {
    static int  elements=0;//读取指针
     int  maxsize=0; //最多存放个数
    long[] array;
    public MyArray(int aaa){  //通过有参的构造函数 初始化 数组
        this.maxsize=aaa;  // 设置 最多存放数据个数
        array=new long[maxsize];   // 确定 数组最多存放多少个数据
    }
    /*
    * 插入数据
    * */
    public void insert(long xxx){
        if(elements<maxsize) {
//            System.out.println(elements);
//            System.out.println(array.length);
            array[elements]=xxx;
            elements++;
        }
    }
    public void display(){
        for(long a:array){
            System.out.println(a+" ");
        }
    }
    public void display2(){
       for(int i=0;i<elements;i++){
           System.out.println(array[i]);
       }
    }
    /*
    * 根据值查找数据
    * */
    public void earch(long f){
        elements=0;
        while(array[elements]!=f){
            elements++;
            if (elements==maxsize-1){
                System.out.println("没找到 这个小可爱啊！");
                break;
            }
        }
        System.out.println(elements);
    }
    /*
     * 根据索引查找数据
     * */
    public void indexsearch(int xxxx){
        if(xxxx<maxsize){
            System.out.println(array[xxxx]);
        }else {
            System.out.println("没有这么大的下标");
        }
    }

    /*
     * 查找数据 （二分法查找） 必须是有序数组
     * */
    public int binarySearch(int xxxx) {
        int middle=0;
        int low=0;
        int pow=elements;
        while(true){
            middle=(pow+low)/2;
            if(middle==xxxx){
                return middle;
            }else if(low>pow){
                System.out.println("数组有错误");
                return -1;
            }else {
                if (middle>xxxx){

                }
            }
        }
    }
    /*
    * 根据下标删除数据（毫无逻辑的 方法）
    * */
    public long[] delete(int x){
        int a=x;
        if (x<=maxsize-2) {  //如果要删除的 数据的下标 小于maxsize（最多个数）-2
            for(a=0;a<maxsize-1;a++) {
                array[a] = array[a + 1];
            }
            array[maxsize-1]=0;
            maxsize=maxsize-1;
        }else if(x==maxsize-1){
            array[maxsize-1]=0;
        }
//        maxsize--;  //不能这么写  因为 按照逻辑 你每删除一个 数据 就需要变更一下 数组 最多能储存多少个 着实搞笑
        elements--;
        return array;
    }
    /*
     * 根据下标删除数据(根据指针）
     * */
    public long[] delete1(int x){
        if(elements<x){
            System.out.println("不存在这个坐标");
        }else if(x!=elements){
            for(int a=x;a<elements;a++) {
                array[a] = array[a + 1];
                elements--;
            }
        }else {
            elements--;
        }
        return array;
    }
    /*
    * 添加有序数组
    * */
    public void insertasc(long a){
        if(elements==0){
            array[elements]=a;
            elements++;
        }else {
            for (int i = 0; i <=elements; i++) {  // 遍历整个数组
                if(array[elements-1]<a){ //当数组里面数都小于a时候
                    array[elements]=a; //指针直接后移赋值
                    elements++;
                    break;
                }
                if (a > array[i]&&a<array[i+1]) {  // 确定 整个数组中  他的前面比他小  后面比他大的位置
                    for(int b=elements;b>=i;b--){
                        array[b+1]=array[b];     //插进去
                    }
                    array[i+1]=a;
                    elements++;
                    break;
                }
                if(a<array[elements-1]){
                    array[elements]=array[elements-1];
                    array[elements-1]=a;
                    elements++;
                    break;
                }
            }

        }
    }
    public void chage(int index,long value){
        array[index]=value;
    }
    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

}
