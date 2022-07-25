package D20;

import java.util.PriorityQueue;

/**
 * @author zjy
 * @version 1.0
 * 第K大的数据
 */

public class I1 {
}
class KthLargest {

    /**
     * 使用小根堆来实现，Java里的优先队列是使用小根堆的。
     * 大根堆，只需要构建的时候，传入一个比较器即可
     * @param k
     * @param nums
     */
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int i : nums){
            pq.add(i);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
