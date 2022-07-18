package D12;

/**
 * @author zjy
 * @version 1.0
 * 请根据每日 气温 列表 temperatures，重新生成一个列表，
 * 要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/iIQa4I
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 分析：当索引为i时，找到比n[i]更大的n[j]
 */
public class I3 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        res[n-1] = 0;
        // 最后一天一定是0
        Deque<Integer> temper = new ArrayDeque<>();
        // 记录对应天数
        Deque<Integer> day = new ArrayDeque<>();
        temper.push(temperatures[n-1]);
        day.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while(!temper.isEmpty() && temperatures[i] >= temper.peek()){
                temper.pop();
                day.pop();
            }
            int days = temper.isEmpty() ? 0 : day.peek() - i + 1;
            temper.push(temperatures[i]);
            day.push(i);
            res[i] = days;
        }
        return res;
    }
}
