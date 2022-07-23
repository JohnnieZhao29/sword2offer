package D18;

/**
 * @author zjy
 * @version 1.0
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。
 * 如果节点没有中序后继，请返回 null 。
 *
 * 节点p的后继是值比p.val大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 *
 *
 */


/**
 * 分析：对于BST来说，一个节点的后继节点是它的右子树的最左边节点，或者是它的父节点。
 */
public class I1 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        TreeNode successor = null;
        if(root.val > p.val){
            successor = inorderSuccessor(root.left, p);
            if(successor == null){
                successor = root;
            }
        }
        if(root.val < p.val){
            successor = inorderSuccessor(root.right, p);
        }
        if(root.val == p.val){
            successor = getMinNode(root.right);
        }
        return successor;
    }

    public TreeNode getMinNode(TreeNode root){
        while(root != null && root.left != null){
            root = root.left;
        }
        return root;
    }
}
