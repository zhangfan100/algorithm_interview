package lianbiao;

/**
 * 将给定的单链表\ L L： L_0→L_1→…→L_{n-1}→L_ nL
 * 重新排序为：L_0→L_n →L_1→L_{n-1}→L_2→L_{n-2}→…L
 * 要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
 *
 * 数据范围：链表长度 0 \le n \le 200000≤n≤20000 ，链表中每个节点的值满足 0 \le val \le 10000≤val≤1000
 *
 * 要求：空间复杂度 O(n)O(n) 并在链表上进行操作而不新建链表，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(1)O(1) ， 时间复杂度 O(n)O(n)
 */
public class 重排链表 {

    /**
     * 输入：
     * {1,2,3,4}
     * 返回值：
     * {1,4,2,3}
     * 说明：
     * 给定head链表1->2->3->4, 重新排列为 1->4->2->3,会取head链表里面的值打印输出 1
     * @param head
     */
    public static void reorderList(Node head) {
        Node nextNode = null;
        Node revNode = null;
        Node curNode = head;
        while(curNode != null){
            nextNode = curNode.next;
            if (nextNode == null || nextNode.next == null){
                return;
            }
            // 找到最后一个节点 截取出来挂载到
            revNode = nextNode;
            Node preNode = revNode;
            while (revNode != null && revNode.next != null){
                preNode = revNode;
                revNode= revNode.next;// 一直找到最后一个节点
            }
            if (preNode != null){
                preNode.next = null;// 截断
            }
            curNode.next = revNode;
            revNode.next = nextNode;
            curNode = curNode.next.next;
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        Util.print("处理前",node4);
        reorderList(node4);
        Util.print("处理后",node4);

    }

}
