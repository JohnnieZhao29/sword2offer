package D19;

/**
 * @author zjy
 * @version 1.0
 * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在
 * 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，
 * 同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 */


import java.util.HashMap;
import java.util.HashSet;

/**
 * 索引的差值小于等于k，索引对应的数的差值小于等于t。
 */
public class I2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long, Long> map = new HashMap<>();
        int n =nums.length;
        long nt = (long) t+1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], nt);
            if(map.containsKey(id)){
                return true;
            }
            if(map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id-1)) < nt){
                return true;
            }
            if(map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id+1)) < nt){
                return true;
            }
            map.put(id,(long) nums[i]);
            if( i >= k) {
                map.remove(getID(nums[i - k], nt));
            }
        }
        "12".hashCode();
        return false;
    }

    private long getID(long num, long nt) {
        if(num >= 0){
            return num / nt;
        }
        return (num + 1) / nt - 1;
    }
}
