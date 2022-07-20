package D15;

/**
 * @author zjy
 * @version 1.0
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 */

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 分析：进入循环的前提条件是，队列不为空，然后更新每层最左边的数
 */

public class I2 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = root.val;
        while(!queue.isEmpty()){
            int curLen = queue.size();
            for (int i = 0; i < curLen; i++) {
                TreeNode node = queue.poll();
                if(i == 0){
                    res = node.val;
                }
                if(node.left != null)   queue.offer(node.left);
                if(node.right != null)   queue.offer(node.right);
            }
        }
        return res;
    }
}
