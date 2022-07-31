package D26;

/**
 * @author zjy
 * @version 1.0
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class I2 {
    // 归并排序
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode last = splitList(head);
        head = sortList(head);
        last = sortList(last);
        return merge(head, last);
    }
    public ListNode splitList(ListNode head){
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 对应前半段的最后一个
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }

    public ListNode merge(ListNode head, ListNode last){
        // head和last都是有序的
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode h = head, l = last;
        while(h != null && l != null){
            ListNode node;
            if(h.val >= l.val){
                node = new ListNode(l.val);
                l = l.next;
            }else{
                node = new ListNode(h.val);
                h = h.next;
            }
            p.next = node;
            p = p.next;
        }
        if(h == null){
            p.next = l;
        }else{
            p.next = h;
        }
        return dummy.next;
    }
}
