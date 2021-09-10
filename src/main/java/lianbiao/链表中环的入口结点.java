package lianbiao;

/**
 * 分析见  https://blog.csdn.net/weixin_43729854/article/details/104246017
 */
public class 链表中环的入口结点 {

    public Node EntryNodeOfLoop(Node pHead) {

        Node slow = pHead;
        Node quick = pHead;

        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if (slow == quick){
                break;// 说明相遇了
            }
        }
        if (quick == null || quick.next == null){
            // 没环
            return  null;
        }

        slow = pHead;
        while (slow != quick){
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }

}
