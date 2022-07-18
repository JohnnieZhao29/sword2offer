package D13;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zjy
 * @version 1.0
 */

public class I2 {
    public int maximalRectangle(String[] matrix) {
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length();
        // m行 n列
        int[] heights = new int[n];
        int ans = Integer.MIN_VALUE;
        int rows = 0;
        while(rows < m){
            for (int i = 0; i < heights.length; i++) {
                int cur = matrix[rows].charAt(i) - '0';
                if(cur != 0) {
                    heights[i] += cur;
                }else{
                    heights[i] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
            rows++;
        }
        return ans;
    }
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
