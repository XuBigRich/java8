package sjjg.shuzu;

import sjjg.paixu.Sort;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestArry.java
 * @Description TODO
 * @createTime 2019年02月18日 18:41:00
 */
public class TestArray {

    public static void main(String[] args) {
        MyArray myArray=new MyArray(4);
//        myArray.insert(3L);
//        myArray.insert(5L);
//        myArray.insert(7L);
//        myArray.display();
//        myArray.earch(6);
//        myArray.indexsearch(0);
//        myArray.indexsearch(2);
//        myArray.delete(0);
//        myArray.delete(1);
//        myArray.delete1(1);
//        myArray.display();
        myArray.insertasc(3L);
        myArray.insertasc(1L);
//        myArray.display2();
        myArray.insertasc(7L);
//        myArray.display2();
        myArray.insertasc(5L);
        myArray.display2();
//        System.out.println("================================");
        DemoArray demoArray=new DemoArray(4);
        demoArray.insertasc(26L);
        demoArray.insertasc(63L);
        demoArray.insertasc(56L);
        demoArray.insertasc(6L);
       int b= demoArray.binarySearch(63 );
//        demoArray.delete(1);
        demoArray.display();
        System.out.println(b);
        System.out.println(demoArray.getArry().length);


        long [] a={61L,22L,86L,9L,-9L};
        long [] d={61L,22L,86L,9L,-9L};
        long [] e={61L,-9L,86L,9L,22L};
        Sort sort=new Sort();
        long[] w=sort.bubbleSort(a);
        long[] q=sort.selecSort(d);
        long[] f=sort.insertSort(e);
        for(int i=0;i<w.length;i++){
            System.out.print(w[i]+" ");
        }
        System.out.println("\n==================");
        for(int i=0;i<w.length;i++){
            System.out.print(q[i]+" ");
        }
        System.out.println("\n==================");
        for(int i=0;i<w.length;i++){
            System.out.print(f[i]+" ");
        }
//        System.out.println(a[0]);
    	}
}
