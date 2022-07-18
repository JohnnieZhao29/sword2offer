package D12;

/**
 * @author zjy
 * @version 1.0
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，
 * 正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
 * 每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。
 * 碰撞规则：两个行星相互碰撞，较小的行星会爆炸。
 * 如果两颗行星大小相同，则两颗行星都会爆炸。
 * 两颗移动方向相同的行星，永远不会发生碰撞。
 *
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 分析：++ -- +- -+ 只有 +- 会发生碰撞
 * 先入栈第一个
 */

public class I2 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(asteroids[0]);
        int i = 1;
        while(i < asteroids.length){
            int temp = asteroids[i];
            boolean alive = true; // 小新星是否存活
            i++;
            while(alive && temp < 0 && !stack.isEmpty() && stack.peek() > 0 ){
                alive = stack.peek() < -temp;
                if(stack.peek() <= -temp){
                    stack.pop();
                }
            }
            if(alive){
                stack.push(temp);
            }
        }
        int[] ans = new int[stack.size()];
        for (int j = ans.length-1; j >=0; j--) {
            ans[j] = stack.pop();
        }
        return ans;
    }
}
