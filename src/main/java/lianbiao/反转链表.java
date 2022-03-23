package lianbiao;

import java.util.ArrayList;
import java.util.List;

/**
 * 2种方法
 * 1、递归反转
 * 2、遍历反转
 */
public class 反转链表 {

    // 递归反转
    public Node reverseList1(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        // 指针移到下一个位置 便于后面记录
        Node nextNode = node.next;
        // 先递归找到最后一个反转
        Node newHeader = reverseList1(node.next);
        // 3->4   指针反转   4->3
        nextNode.next = node;
        // 当前位置后面截断
        node.next = null;
        return newHeader;
    }

    // 遍历反转
    public Node  reverseList2(Node node) {

        // 记录反转的元素
        Node pre = null;
        // 记录下一个位置
        Node next = null;
        while(node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node =  next;
        }
        return pre;

    }

    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(4, null))));
        Util.print("反转前",node);
        Util.print("递归反转后",new 反转链表().reverseList1(node));

        node = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(4, null))));
        Util.print("反转前",node);
        Util.print("遍历反转后",new 反转链表().reverseList2(node));

    }


    public Node fz(Node header){
        if(header == null || header.next == null){
            return header;
        }
        Node next = header.next;
        Node newNode = fz(header.next);
        next.next=header;
        header.next=null;
        return newNode;
    }
}


