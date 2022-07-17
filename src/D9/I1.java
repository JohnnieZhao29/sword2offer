package D9;

import java.util.List;

/**
 * @author zjy
 * @version 1.0
 */

public class I1 {
    // 一个简单的想法就是反转后是否和原来链表一样，空间复杂度O(N)
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        ListNode mid = slow;
        // 反转后面的 mid -- > end
        ListNode right = reverseList(mid);
        slow.next = null;
        ListNode p = head;
        ListNode q = right;
        boolean res = true;
        while(q != null){
            if(p.val != q.val){
                res = false;
                break;
            }
            p = p.next;
            q = q.next;
        }
        return res;
    }
    public ListNode reverseList(ListNode head){
        if(head.next == null || head == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
