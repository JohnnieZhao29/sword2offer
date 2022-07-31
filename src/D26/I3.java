package D26;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zjy
 * @version 1.0
 */

public class I3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode listNode : lists){
            ListNode q = listNode;
            while(q != null){
                queue.offer(q);
                q = q.next;
            }
        }
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            p.next = poll;
            p = p.next;
        }
        p.next = null;
        return dummy.next;

    }
}
