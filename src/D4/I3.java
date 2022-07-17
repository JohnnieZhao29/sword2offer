package D4;

/**
 * @author zjy
 * @version 1.0
 * 给你一个整数数组nums ，请计算数组的中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 *
 */

public class I3 {
    public int pivotIndex(int[] nums) {
        /**
         * 前缀和问题
         * [0...i-1]的和 = [i+1...n]的和
         * pre[i-1] = pre[n]-pre[i]
         * 满足，则更新i值；
         */
        int n = nums.length;
        int[] pre = new int[n];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            pre[i] = preSum;
        }

        int res = Integer.MAX_VALUE;
        // 左右边界肯定有个是符合的，先记录
        if(pre[n-1] == pre[0]){
            res = 0;
        }else if(pre[n-2] == 0){
            res = n-1;
        }

        for(int i = 1; i < n-1; i++){
            int left = pre[i-1];
            int right = pre[n-1] - pre[i];
            if(left == right){
                res = Math.min(res, i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
