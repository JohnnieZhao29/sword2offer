package D17;

/**
 * @author zjy
 * @version 1.0
 */

public class I3 {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = increasingBST(root.left);
        root.left = null;
        TreeNode right = increasingBST(root.right);
        root.right = right;

        if(left == null){
            return root;
        }
        TreeNode p = left;
        while(p != null && p.right != null){
            p = p.right;
        }
        p.right = root;
        return left;
    }
}
