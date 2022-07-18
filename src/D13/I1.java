package D13;

/**
 * @author zjy
 * @version 1.0
 * 给定非负整数数组 heights，
 * 数组中的数字用来表示柱状图中各个柱子的高度。
 * 每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/0ynMMM
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 分析，单调栈可解
 * 从当前位置向左右扩展，直到比当前位置要小。
 */
public class I1 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // 左边界
        for (int i = 0; i < n; i++) {
            while( !stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        // 右边界
        for (int i = n-1; i >= 0; i--) {
            while( !stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = n;
            }else{
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = heights[i] * (right[i] - left[i] - 1);
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
