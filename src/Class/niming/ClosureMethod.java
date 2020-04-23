package Class.niming;

import java.util.List;

public abstract class ClosureMethod<V> {
    public  List filter(List list, Method method) {
        return method.filter(list);
    }
}
