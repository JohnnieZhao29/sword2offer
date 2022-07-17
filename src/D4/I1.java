package D4;

import java.util.HashMap;

/**
 * @author zjy
 * @version 1.0
 * 和为k的子数组的数量
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 */

public class I1 {
    public int subarraySum(int[] nums, int k) {
        int pre = 0;
        int n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // map:前缀和为key的子数组有value个
        // 需要人为添加一个前缀和为0的子数组有1个。
        // pre[i] - k = 0;
        //
        map.put(0,1);
        for(int i = 0; i < n; i++){
            pre += nums[i];
            int temp = pre - k;
            if(map.containsKey(temp)){
                ans += map.get(temp);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
        /** 数组全为正数，可用滑动窗口，不限制则需要前缀和，
         *  [j...i]的和等于pre[i]-pre[j-1]，所以如果pre[i]-target == pre[j-1]，
         *  那么说明[j...i]构成一个子数组，而以i为结尾的子数组中有几个，则要看满足pre[i]-targer == pre[j-1]
         *  的pre[j-1]有几个子数组。
         */
    }
}
