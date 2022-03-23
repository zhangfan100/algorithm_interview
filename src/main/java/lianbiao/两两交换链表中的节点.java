package lianbiao;

public class 两两交换链表中的节点 {

    public Node swapLinkedPair (Node head) {
        // write code here   3->4->5
        if (head == null || head.next == null){
            return head;
        }

        Node newNode = head.next;
        head.next = swapLinkedPair(head.next.next);
        newNode.next = head;
        return newNode;

    }


    public Node swapLinkedPair1 (Node head) {
        // write code here   3->4->5
        if (head == null || head.next == null){
            return head;
        }
        boolean reve = false;
        Node pre = null;
        while (head != null) {
            if (reve) {
                Node curNode = head;//记录当前节点
                head.next = pre;
                pre.next = curNode.next;
            } else {
                // 不需要反转
                pre = head;
            }
            head = head.next;// 指针下移
            reve = !reve;
        }
        return head;

    }

}
