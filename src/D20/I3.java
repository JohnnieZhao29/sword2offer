package D20;

import java.util.*;

/**
 * @author zjy
 * @version 1.0
 * 给定两个以升序排列的整数数组 nums1 和 nums2,以及一个整数 k。
 *
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 *
 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
 *
 *
 */

public class I3 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                pq.offer(new int[]{i,j});
//            }
//        }
//        while (k-- >0 && !pq.isEmpty()){
//            int[] temp = pq.poll();
//            ans.add(Arrays.asList(nums1[temp[0]], nums2[temp[1]]));
//        }
//        return ans;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i,0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            ans.add(Arrays.asList(nums1[idxPair[0]], nums2[idxPair[1]]));
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }
        return ans;
    }
}
