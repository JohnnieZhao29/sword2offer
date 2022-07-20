package D15;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjy
 * @version 1.0
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * 还是层序遍历的问题
 */

public class I1 {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        if(list.isEmpty()){
            list.offer(root);
        }
        // 当做队列去使用
        List<Integer> res = new ArrayList<>();
        while(!list.isEmpty()){
            int size = list.size();
            int tempMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = list.pollFirst();
                tempMax = Math.max(node.val, tempMax);
                if(node.left != null)   list.offer(node.left);
                if(node.right != null)   list.offer(node.right);
            }
            res.add(tempMax);
        }
        return res;
    }
}
