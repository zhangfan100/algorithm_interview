package lianbiao;

public class Util {
    public static void print(String str, Node node) {
        System.out.print(str + "\t");
        if (node != null) {
            System.out.print(node.data + "\t");
            Node next = node.next;
            while (next != null) {
                System.out.print(next.data + "\t");
                next = next.next;
            }
        }
        System.out.println();
    }
}
