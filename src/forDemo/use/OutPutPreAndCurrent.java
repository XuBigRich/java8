package forDemo.use;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 这是一个关于for的骚操作
 *
 * @Author： hongzhi.xu
 * @Date: 2020/11/27 上午10:52
 * @Version 1.0
 */
public class OutPutPreAndCurrent {
    public Node headNode;
    public Node tailNode;

    class Node {
        public int value;
        public Node pre;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 给链表添加节点
     *
     * @param i
     */
    public void addNode(int i) {
        Node node = new Node(i);
        if (headNode == null) {
            headNode = node;
            tailNode = node;
        } else {
            Node pred = tailNode;
            pred.next = node;
            tailNode = node;
            tailNode.pre = pred;
        }
    }

    /**
     * 给链表添加节点
     */
    public void addElement() {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
    }

    /**
     * 遍历链表
     */
    public void traverse() {
        Node current = headNode;
        Node e;
        while (current != null) {
            e = current.next;
            System.out.println(current.getValue());
            current = e;
        }
    }

    /**
     *
     */
    public void forMethod() {
        for (Node current = headNode, next; current != null; next = current) {
            next = headNode.next;
            System.out.println(next.getValue() + " " + current.getValue());
        }
    }

    public static void main(String[] args) {
        OutPutPreAndCurrent outPutPreAndCurrent = new OutPutPreAndCurrent();
        outPutPreAndCurrent.addElement();
        outPutPreAndCurrent.traverse();
    }

}
