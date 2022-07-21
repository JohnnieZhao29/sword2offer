package huisu;

import java.util.LinkedList;

/**
 * @author zjy
 * @version 1.0
 */

public class zijiemianshi {
    public static Integer res = new Integer(Integer.MIN_VALUE);
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,9,3};
        int target = 21563;
        // 找到使用nums组合的最大的小于target的数
        int len = String.valueOf(target).length();
        StringBuilder buffer = new StringBuilder();
        backtrack(nums, target, len, buffer);
        System.out.println(res);
    }

    public static void backtrack(int[] nums, int target,
                                 int len, StringBuilder buffer){
        if(buffer.length() == len){
            int i = Integer.parseInt(buffer.toString());
            if(i < target){
                res = Math.max(res, i);
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            buffer.append(nums[i]);
            backtrack(nums, target, len, buffer);
            buffer.deleteCharAt(buffer.length()-1);
        }
    }
}
