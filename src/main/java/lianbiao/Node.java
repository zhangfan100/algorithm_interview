package lianbiao;

public class Node {
    Object data;
    Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setNext(Node next){
        this.next = next;
    }

}
