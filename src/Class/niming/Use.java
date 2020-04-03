package Class.niming;

import java.util.ArrayList;
import java.util.List;

public class Use extends ClosureMethod {
    public static void main(String[] args) {
        Use use=new Use();
        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(5);
        List f= use.filter(list,e-> {
            List a=new ArrayList();
            for(Object list1:e){
                if((Integer)list1>2) a.add(list1);
            }
            return a;
        });
        System.out.println(f);
    }
}
