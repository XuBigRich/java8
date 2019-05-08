package sjjg.ZhanAndDuilie;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestMyStack.java
 * @Description TODO
 * @createTime 2019年02月26日 11:06:00
 */
public class TestMyStructure {
    public static void main(String[] args) {
        MyStack myStack=new MyStack(5);
        myStack.push(23);
        myStack.push(22);
        myStack.push(6);
        myStack.push(8);
        myStack.push(1);
        System.out.println(myStack.isEmpcy());
        System.out.println(myStack.isFull());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        MyQueue myQueue=new MyQueue(5);
        myQueue.insert(23);
        myQueue.insert(22);
        myQueue.insert(6);
        myQueue.insert(8);
        myQueue.insert(1);
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.isPull());

        while(!myQueue.isEmpty()){
            System.out.println(myQueue.remove());
        }
        myQueue.insert(66);
        myQueue.insert(88);
        while(!myQueue.isEmpty()){
            System.out.println(myQueue.remove());
        }
    	}
}
