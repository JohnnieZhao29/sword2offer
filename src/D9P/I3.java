package D9P;

/**
 * @author zjy
 * @version 1.0
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入
 * 一个新元素insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。
 * 否则。请返回原先给定的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4ueAj6
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class I3 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null){
            node.next = node;
            return node;
        }
        int max = head.val;
        Node maxNode = head, minNode = head;
        Node cur = head.next;
        while(cur != head){
            if(cur.val >= max){
                max = cur.val;
                maxNode = cur;
            }
            cur = cur.next;
        }
        minNode = maxNode.next;
        // 这是一定的
        if(node.val >= maxNode.val || node.val <= minNode.val){
            maxNode.next = node;
            node.next = minNode;
            return head;
        }
        cur = minNode;
        Node pre = maxNode, next = cur.next;
        while(cur.val <= node.val){
            pre = cur;
            cur = next;
            next = next.next;
        }
        pre.next = node;
        node.next = cur;
        return head;
    }
}
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
