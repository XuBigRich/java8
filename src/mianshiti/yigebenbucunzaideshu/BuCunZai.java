package mianshiti.yigebenbucunzaideshu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

/**
 * 一个神奇的判断
 * 他在数学中本不存在 但是在Java世界中 他存在
 * @Author： hongzhi.xu
 * @Date: 2020/11/25 下午2:48
 * @Version 1.0
 */
public class BuCunZai {
    public static void main(String[] args) {
//        LinkedList
//        关键在于Double.NaN，在源码中NaN = 0.0d / 0.0  因为这个结果在内存中存储的是一个无限接近0的小数，0.000000000000001
        //如果即大于Nan 又 小于等于
        if(Double.NaN>Float.NaN || Double.NaN <=Float.NaN){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
        int s;
//        System.out.println(s);
        Float b= 0.0f / 0.0f;
        Integer a=0;
        Integer c=0;
        System.out.println(a/b);
        System.out.println(Double.NaN>Float.NaN);

    }
}
