package D9;

/**
 * @author zjy
 * @version 1.0
 * 貌似需要bfs
 * 有子列表的，先把子列表梳理清楚，然后梳理自己的下一结点，相当于梳理自己
 * dfs，返回当前结点展平后的最后一个结点，这个结点不包括当前结点的next结点
 */

public class I2 {
    public D9P.Node dfs(D9P.Node node){
        D9P.Node cur = node;
        D9P.Node last = null;
        while(cur != null){
//            Queue<Node> queue = new ArrayDeque<>();
            D9P.Node next = cur.next;
            if(cur.child != null){
                D9P.Node childLast = dfs(cur.child);
                next = cur.next;
                // 把next和child相连接
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                if(next != null){

                    childLast.next = next;
                    next.prev = childLast;
                }
                last = childLast;
            }else{
                last = cur;
            }
            cur = next;
        }
        return last;
    }
    public D9P.Node flatten(D9P.Node head) {
        dfs(head);
        return head;
    }
}
class Node {
    public int val;
    public D9P.Node prev;
    public D9P.Node next;
    public D9P.Node child;
}
