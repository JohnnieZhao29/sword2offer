package D8;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = null;
        while( !stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = carry + a + b;
            carry = cur / 10;
            cur = cur % 10;
            ListNode curNode = new ListNode(cur);
            // 前插
            curNode.next = res;
            res = curNode;
        }
        return res;
    }
}
