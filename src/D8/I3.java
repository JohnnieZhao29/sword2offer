package D8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author zjy
 * @version 1.0
 */

public class I3 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        Deque<ListNode> queue = new ArrayDeque<>();
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode fast = head;
        // 找到中点
        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode le = head;
        ListNode ri = mid;
        while(le != mid){
            queue.offer(le);
            stack.push(ri);
            le = le.next;
            ri = ri.next;
        }
        while(ri != null){
            stack.push(ri);
            ri = ri.next;
        }
        while(!queue.isEmpty() && !stack.isEmpty()){
            queue.poll().next = stack.peek();
            stack.pop().next = queue.peekFirst();
        }
        return;
    }
}
