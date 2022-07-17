package D7;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head; // 快指针
        ListNode q = head; // 慢指针
        while(true){
            if(p == null || p.next == null){
                return null;
            }
            p = p.next.next;
            q = q.next;
            if(q == p){
                break;
            }
        }
        // q = p
        q = head;
        while( p != q){
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
