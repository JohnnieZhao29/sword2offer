package D17;

import java.util.HashMap;

/**
 * @author zjy
 * @version 1.0
 * 给定一个二叉树的根节点 root，和一个整数 targetSum，
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，
 * 但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/6eUYwP
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class I1 {
    // Integer res = new Integer(0);
    // Integer target = 0;
//    public int pathSum(TreeNode root, int targetSum) {
//        if(root == null)    return 0;
//        int cur = dfs(root, targetSum);
//        int sub = pathSum(root.left, targetSum) +
//                pathSum(root.right, targetSum);
//        return cur + sub;
//    }
//    public int dfs(TreeNode root, int targetSum){
//        // 返回的是路径能到达叶子节点的和为sum的。
//        // 到达叶子节点，返回叶子节点的值
//        if(root == null){
//            return 0;
//        }
//        int temp = 0;
//        if(root.val == targetSum)  temp++;
//        temp += dfs(root.left,targetSum - root.val);
//        temp += dfs(root.right, targetSum - root.val);
////        int leftSum = dfs(root.left);
////        int rightSum = dfs(root.right);
//
//        return temp;
//    }

    /**
     * 使用dfs+前缀和方法
     * @param root
     * @param targetSum
     * @return
     */
    Integer target;
    Integer preSum;
    Integer res;
    public int pathSum(TreeNode root, int targetSum){
        this.target = targetSum;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        preSum = 0;
        res = 0;
        dfs(root, map);
        return res;
    }
    public void dfs(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return;
        }
        preSum += root.val;
        if(map.containsKey(preSum - target)){
            // 以当前节点为结尾的和为target的路径的数量
            res += map.get(preSum - target);
        }
        map.put(preSum, map.getOrDefault(preSum,0)+1);
        dfs(root.left, map);
        dfs(root.right, map);
        map.put(preSum, map.get(preSum) - 1);
    }
}
