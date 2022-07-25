package D20;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zjy
 * @version 1.0
 *
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可
 * 以按 任意顺序 返回答案。
 *
 */

/**
 * 由于随着元素插入，频率前k高的元素会不断更新，所以使用小根堆，
 * 因为插入的是数组，第一个代表元素，第二个表达出现次数，所以重写Comparator比较器，
 */
public class I2 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int num : nums ){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            if(pq.size() == k){
                if(pq.peek()[1] <= freq){
                    pq.poll();
                    pq.offer(new int[]{num, freq});
                }
            }else{
                pq.offer(new int[]{num, freq});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
