package D18P;

/**
 * @author zjy
 * @version 1.0
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 */

/**
 * BTS的中序遍历才能得到一个有序的数组，先左后右就是递增，先右后左就是递减。
 */

public class i2 {

    Integer sum = new Integer(0);
    public TreeNode convertBST(TreeNode root) {
        if(root == null)    return null;
        int cur = root.val;
        // 记录当前节点值
        convertBST(root.right);
        root.val = cur +sum;
        convertBST(root.left);
//        root.val = cur + sum;
        return root;
    }
}
