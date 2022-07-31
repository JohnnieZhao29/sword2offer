package D24;

/**
 * @author zjy
 * @version 1.0
 * 给定一个正整数数组w ，其中w[i]代表下标 i的权重（下标从 0 开始），
 * 请写一个函数pickIndex，它可以随机地获取下标 i，选取下标 i的概率与w[i]成正比。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），
 * 而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
 *
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 *
 *
 *
 */

public class I1 {

}
class Solution{

    int[] preSum;
    int sum;
    public Solution(int[] w) {
        preSum = new int[w.length];
        for (int i = 0; i < preSum.length; i++) {
            sum += w[i];
            preSum[i] = sum;
        }
    }

    public int pickIndex() {
        int rand = (int) (Math.random() * sum) + 1;
        return getIndexFromPreSum(rand);
        // 随机选择一个数，在第一个数到总和之间，第一个数不可选到，最后一个数可选到。
    }

    // 找到小于rand的最大的索引的位置
    public int getIndexFromPreSum(int rand){
        int left = 0, right = preSum.length-1;
        while(left < right){
            int mid = left + (right - left ) >> 2;
            if(preSum[mid] > rand){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
