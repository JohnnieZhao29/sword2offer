package D4;

import java.util.HashMap;

/**
 * @author zjy
 * @version 1.0
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1
 * 的最长连续子数组，并返回该子数组的长度。
 */

public class I2 {
    public int findMaxLength(int[] nums) {
        // 前缀和
        // 1的数量和0的数量相同，那么把0当作-1的话，就是和为0
        // 那么求最长子数组内0，1的数量相等，就成了最长子数组内，和为0
        // 和D4I1相同，找到子数组的时候，需要更新子数组的长度，这里map维护的是子数组和为key
        // 的最靠前的数组下标value
        // pre[i]代表[0..i]的数组元素的和，
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums2.length; i++) {
            if(nums[i] == 1){
                nums2[i] = nums[i];
            }else{
                nums2[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int res = Integer.MIN_VALUE;
        map.put(0,-1);
        for(int i = 0; i < nums2.length; i++){
            pre += nums2[i];
            if(map.containsKey(pre)){
                int preIndex = map.get(pre);
                res = Math.max(res, i - preIndex);
            }else{
                map.put(pre,i);
            }
        }
        return res;
    }
}
