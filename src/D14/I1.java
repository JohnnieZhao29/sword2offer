package D14;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author zjy
 * @version 1.0
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 *
 * 实现 MovingAverage 类：
 *
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val)
 * 成员函数 next
 * 每次调用的时候都会往滑动窗口增加一个整数，
 * 请计算并返回数据流中最后 size 个值的移动平均值，
 * 即滑动窗口里所有数字的平均值。
 *
 *
 */

class MovingAverage {


    Deque<Integer> queue;
    int cache;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.cache = size;
        this.queue = new ArrayDeque<>();
    }

    public double next(int val) {
        if(!queue.isEmpty() && queue.size() >= cache){
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}


public class I1 {
}
