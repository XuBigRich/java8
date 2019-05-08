package sjjg.paixu;

public class Sort {
/*
* 冒泡排序
*
* 原理 ：里层循环 每次循环都会把最小的 数排到第一个
*       所以外层循环 可以直接 排除 已经 排列好的 数字 只 循环 剩下的
*
* */
    public long[]  bubbleSort(long [] a){
            long emp=0;
        /*外层循环*/   for(int i=0;i<a.length-1;i++){//控制对比几次：之所以i < length-1是因为  如果 数组长度为1时就无需遍历了
                            //i代表已经完成的指向
       /*里层循环*/         for(int j=a.length-1;j>i;j--){ //从数组最后一个数开始往前对比 到第i个
                                if(a[j]<a[j-1]){
                                    emp=a[j];
                                    a[j]=a[j-1];
                                    a[j-1]=emp;
                                }
                           }
                        }
            return a ;
            }
/*
* 选择排序
* 选出最小的一个数排到最前面(效率比 冒泡排序高)
* 外层循环：此处 外层循环要区别与冒泡排序   因为 这里的外层循环是为了 遍历数组
* */
    public long[] selecSort(long[] a){
        int k=0;

        for(int i=0;i<a.length;i++){
            long emp=0;
            for (int j=i;j<a.length;j++){
               if(a[k]>a[j]){
                   k=j;
               }
            }
            emp=a[k];
            a[k]=a[i];
            a[i]=emp;
        }
        return a;
    }
/*
* 插入排序
* */
    public long[] insertSort(long[] a){
        long emp=0;
        for(int i=1;i<a.length;i++){
            emp=a[i];
            int j=i-1;
          while(emp<a[j-1]&&j>0){  // j>0一定要放在emp<a[j-1] 前面 要不然 会报异常
              a[j+1]=a[j];  // 这样循环完 会出现类似于 [6] [6] [12] [95] [63]
              j--;
          }
          a[j]=emp;  // 最后 emp插入到a[j]的位置  因为 a[j]与a[j+1] 为一样的数字 a[j]给他覆盖掉就好
        }
        /*for(int i=1;i<a.length;i++){
            emp=a[i];
            int j=i;
            while(j>0&&emp<a[j-1]){  // 选出小的往前怼
                a[j]=a[j-1];
                j--;
            }
            a[j]=emp;
        }*/
        return a;
    }
}