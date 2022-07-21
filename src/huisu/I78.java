package huisu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjy
 * @version 1.0
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */

/**
 * 元素的相对顺序不变，保证
 */
public class I78 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start){
        res.add(new LinkedList<>(track));
        for(int i = start; i < nums.length; i++){
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }

}
