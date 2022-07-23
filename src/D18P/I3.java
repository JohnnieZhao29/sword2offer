package D18P;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zjy
 * @version 1.0
 * 实现一个二叉搜索树迭代器类BSTIterator ，
 * 表示一个按中序遍历二叉搜索树（BST）的迭代器：
 *
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。
 * BST 的根节点 root 会作为构造函数的一部分给出。
 * 指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 可以假设next()调用总是有效的，也就是说，当调用 next()时，
 * BST 的中序遍历中至少存在一个下一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kTOapQ
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class BSTIterator {
    /*
    维护一个数组
     */
    LinkedList<Integer> iterator;

    public BSTIterator(TreeNode root) {
        iterator = new LinkedList<>();
        tree2iterator(root);
    }

    public void tree2iterator(TreeNode root){
        if(root == null){
            return;
        }
        tree2iterator(root.left);
        iterator.add(root.val);
        tree2iterator(root.right);
    }

    public int next() {
        return iterator.remove();
    }

    public boolean hasNext() {
        return !iterator.isEmpty();
    }
}


public class I3 {

}
