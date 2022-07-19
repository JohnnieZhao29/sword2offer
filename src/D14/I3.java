package D14;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjy
 * @version 1.0
 * 向完全二叉树中添加节点
 */

public class I3 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CBTInserter {

    LinkedList<TreeNode> q;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new LinkedList<>();
    }

    /**
     * 一定是判断当前结点，如果左或者右为空，接上新结点，否则，将当前结点的左右结点入队列
     * @param v
     * @return
     */
    public int insert(int v) {
        TreeNode nodeNew = new TreeNode(v);
        if(q.isEmpty()) {
            q.offer(root);
        }
        while(!q.isEmpty()){
            TreeNode nodeCur = q.poll();
            if(nodeCur.left == null){
                nodeCur.left = nodeNew;
                q.addFirst(nodeCur);
            }else if(nodeCur.right == null){
                nodeCur.right = nodeNew;
                q.addFirst(nodeCur);
            }else{
                q.offer(nodeCur.left);
                q.offer(nodeCur.right);
                continue; // 进入下一次循环，不会到return
            }
            return nodeCur.val;
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}

