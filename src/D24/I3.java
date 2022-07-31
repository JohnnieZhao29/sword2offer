package D24;

import java.util.Arrays;

/**
 * @author zjy
 * @version 1.0
 *
 * 狒狒喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有piles[i]根香蕉。
 * 警卫已经离开了，将在 h 小时后回来。
 *
 * 狒狒可以决定她吃香蕉的速度 k （单位：根/小时）。
 * 每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，
 * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉，
 * 下一个小时才会开始吃另一堆的香蕉。
 *
 * 狒狒喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 * 每一堆香蕉，吃掉需要的时间是 (piles[i] + k - 1) / k;
 *
 */

public class I3 {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        if(h == piles.length){
            return piles[n - 1];
        }
        // 速度最大就是这个
        int lo = 1, hi = piles[n - 1];
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            long temp = getTime(piles, mid);
            if(temp <= h){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    public long getTime(int[] piles, int k){
        long time = 0;
        for (int pile : piles) {
            int curTime = (k + pile - 1) / k;
            time += curTime;
        }
        return time;
    }
}
