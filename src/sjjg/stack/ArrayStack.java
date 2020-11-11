package sjjg.stack;


import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * 对ArrrayStack的学习
 * <p>
 * 栈是一种后进先出(LIFO)的数据结构。
 * ArrayStack使用数组来实现，LinkedStack使用链表来实现，各有特点，也都非常简单。
 * 可以说这两个版本就是SimpleArrayList和SimpleLinkedList的简化版。
 *
 * @param <E> Type of object in this stack
 * @Author： hongzhi.xu
 * @Date: 2020/10/23 9:43 上午
 * @Version 1.0
 *
 * <p>Imported copy of the <code>ArrayStack</code> class from
 * Commons Collections, which was the only direct dependency from Digester.</p>
 *
 * <p><strong>WARNNG</strong> - This class is public solely to allow it to be
 * used from subpackages of <code>org.apache.commons.digester</code>.
 * It should not be considered part of the public API of Commons Digester.
 * If you want to use such a class yourself, you should use the one from
 * Commons Collections directly.</p>
 *
 * <p>An implementation of the {@link java.util.Stack} API that is based on an
 * <code>ArrayList</code> instead of a <code>Vector</code>, so it is not
 * synchronized to protect against multi-threaded access.  The implementation
 * is therefore operates faster in environments where you do not need to
 * worry about multiple thread contention.</p>
 *
 * <p>Unlike <code>Stack</code>, <code>ArrayStack</code> accepts null entries.
 * </p>
 * @see java.util.Stack
 * @since Digester 1.6 (from Commons Collections 1.0)
 * <p>
 * 这个类是Tomcat自己创建的一个栈的数据类型 他继承自ArrayList
 */
public class ArrayStack<E> extends ArrayList<E> {

    /**
     * Ensure serialization compatibility
     */
    private static final long serialVersionUID = 2130079159931574599L;

    /**
     * Constructs a new empty <code>ArrayStack</code>. The initial size
     * is controlled by <code>ArrayList</code> and is currently 10.
     */
    public ArrayStack() {
        super();
    }

    /**
     * Constructs a new empty <code>ArrayStack</code> with an initial size.
     *
     * @param initialSize the initial size to use
     * @throws IllegalArgumentException if the specified initial size
     *                                  is negative
     */
    public ArrayStack(int initialSize) {
        super(initialSize);
    }

    /**
     * Return <code>true</code> if this stack is currently empty.
     * <p>
     * This method exists for compatibility with <code>java.util.Stack</code>.
     * New users of this class should use <code>isEmpty</code> instead.
     *
     * @return true if the stack is currently empty
     */
    public boolean empty() {
        return isEmpty();
    }

    /**
     * Returns the top item off of this stack without removing it.
     *
     * @return the top item on the stack
     * @throws EmptyStackException if the stack is empty
     *                             <p>
     *                             只读取最后一个数据
     */
    public E peek() throws EmptyStackException {
        int n = size();
        if (n <= 0) {
            throw new EmptyStackException();
        } else {
            return get(n - 1);
        }
    }

    /**
     * Returns the n'th item down (zero-relative) from the top of this
     * stack without removing it.
     *
     * @param n the number of items down to go
     * @return the n'th item on the stack, zero relative
     * @throws EmptyStackException if there are not enough items on the
     *                             stack to satisfy this request
     *                             <p>
     *                             忽略n个取出数据
     */
    public E peek(int n) throws EmptyStackException {
        int m = (size() - n) - 1;
        if (m < 0) {
            throw new EmptyStackException();
        } else {
            return get(m);
        }
    }

    /**
     * Pops the top item off of this stack and return it.
     *
     * @return the top item on the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E pop() throws EmptyStackException {
        int n = size();
        if (n <= 0) {
            throw new EmptyStackException();
        } else {
            return remove(n - 1);
        }
    }

    /**
     * Pushes a new item onto the top of this stack. The pushed item is also
     * returned. This is equivalent to calling <code>add</code>.
     *
     * @param item the item to be added
     * @return the item just pushed
     */
    public E push(E item) {
        add(item);
        return item;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.peek(1));
    }
}
