package D17;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    int res = Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int curSum = root.val + left + right;

        res = Math.max(res, curSum);
        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
