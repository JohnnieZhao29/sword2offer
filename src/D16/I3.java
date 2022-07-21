package D16;

/**
 * @author zjy
 * @version 1.0
 * 给定一个二叉树 根节点root，树的每个节点的值要么是 0，要么是 1。
 * 请剪除该二叉树中所有节点的值为 0 的子树。
 *
 * 节点 node 的子树为node 本身，以及所有 node的后代。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pOCWxh
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import com.sun.source.tree.Tree;

/**
 * 可以使用dfs从低往上剪，当都是0的时候，则剪掉当前节点，否则返回false
 */
public class I3 {


    public TreeNode pruneTree(TreeNode root) {
        // if(root == null){
        //     return root;
        // }
        // root.left = pruneTree(root.left);
        // root.right = pruneTree(root.right);
        // if(root.left == null && root.right == null && root.val == 0){
        //     root = null;
        // }
        // return root;
        dfs(root);
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }

    public boolean dfs(TreeNode root){
        if(root == null){
            return true;
        }
        // boolean sub = dfs(root.left) && dfs(root.right);
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        boolean sub = left && right;
        if(left){
            root.left = null;
        }
        if(right){
            root.right = null;
        }
        boolean ans = false;
        if(sub && root.val == 0){
            ans = true;
        }
        return ans;
    }

}
