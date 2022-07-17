package D8;



/**
 * @author zjy
 * @version 1.0
 */

public class I1 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode back = reverseList(head.next);
        head.next.next = head;
        head.next = null; // 保证最后一个节点反转后
        return back;
    }

}
