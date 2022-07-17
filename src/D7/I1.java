package D7;

import java.util.List;

/**
 * @author zjy
 * @version 1.0
 */

public class I1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
// 对于链表来说，一定要找到前置结点
        ListNode virtual = new ListNode(-1);
        virtual.next = head;
        ListNode p = virtual.next;
        ListNode pre = virtual;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while(p!=null){
            p = p.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return virtual.next;
    }
}
