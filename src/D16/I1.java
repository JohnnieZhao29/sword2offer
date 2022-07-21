package D16;

/**
 * @author zjy
 * @version 1.0
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 *
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 *
 *
 */


/**
 * 从上往下，遍历到底部的时候，记录当前数字，最后求和
 */
public class I1 {
    Integer res = new Integer(0);
    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, StringBuilder buffer){
        if(root == null){
            return;
            // 当前节点为空，才返回。
        }

        // 到达了根部
        buffer.append(root.val);
        if(root.left == null && root.right == null){
            res += Integer.parseInt(buffer.toString());
            // 注意，这里不能返回；
            // 如果这里返回，那么就无法撤销选择。
        }
        dfs(root.left, buffer);
        dfs(root.right, buffer);
        buffer.deleteCharAt(buffer.length()-1);
    }
}
