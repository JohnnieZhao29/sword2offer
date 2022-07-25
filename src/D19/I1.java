package D19;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zjy
 * @version 1.0
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k ,
 * 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。
 * 假设二叉搜索树中节点的值均唯一。
 */

public class I1 {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
