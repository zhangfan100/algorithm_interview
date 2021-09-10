package lianbiao;

public class 判断链表中是否有环 {

    public boolean hasCycle(Node head) {
        Node oneStep = head;
        Node twoStep = head;
        while(twoStep != null && twoStep.next !=null){
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
            if (twoStep == oneStep){
                System.out.println("存在环");
                return true;
            }
        }
        System.out.println("不存在环");
        return false;
    }

    public static void main(String[] args) {

        Node node = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(4, null))));
        new 判断链表中是否有环().hasCycle(node);

        Node node4 = new Node(4,null);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        node4.setNext(node1);
        new 判断链表中是否有环().hasCycle(node1);
    }

}
